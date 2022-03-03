package demidova.alcodb.presenter

import android.util.Log
import com.github.terrakok.cicerone.Router
import demidova.alcodb.db.dao.AlcoDao
import demidova.alcodb.db.entity.AlcoEntity
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.model.AlcoList
import demidova.alcodb.model.Repository
import demidova.alcodb.network.NetworkStatus
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.main.MainViewFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlcoPresenter(
    private val repository: Repository,
    private val router: Router,
    private val alcoDao: AlcoDao,
    private val networkStatus: NetworkStatus
) :
    MvpPresenter<MainViewFragment>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        var listADO = mutableListOf<AlcoDataObject>()
        Log.d("gopa wi", "${networkStatus.isOnline()}")
        if (networkStatus.isOnline()) {
            repository.getAllAlcoholicCocktails()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ alcoList ->
                    listADO = convertAlcoListToListADO(alcoList) as MutableList<AlcoDataObject>

                    viewState.updateList(listADO)
                    Log.d("gopa", "$listADO")
                    listADO.forEach {
                        saveAlco(conertAlcoListADOToAlcoEntity(it))

                    }

                },
                    {
                        viewState.showError(it.message)
                    })

        } else{
            Log.d("gopa wi", "else")
            alcoDao.getAllAlco()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({listEntity->


                           listEntity.forEach {
                             listADO.add(convertEntityToADO(it))

                           }
                    viewState.updateList(listADO)
                },{
                    Log.d("gopa wi", "Err")
                    viewState.showError(it.message)
                })
        }

    }

    fun onUserClicked(alco: AlcoDataObject) {
        router.navigateTo(AppScreens.detailsScreen(alco))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun goToImageConverter() {
        router.navigateTo(AppScreens.imageConverter())
    }

    private fun convertAlcoListToListADO(alcoList: AlcoList): List<AlcoDataObject> {
        val listADO = mutableListOf<AlcoDataObject>()
        alcoList.drinks.forEach {
            listADO.add(it)
        }
        return listADO
    }

    private fun conertAlcoListADOToAlcoEntity(alco:  AlcoDataObject ) :  AlcoEntity {
         return AlcoEntity(
             strDrink = alco.strDrink,
             strDrinkThumb = alco.strDrinkThumb,
             idDrink = alco.idDrink
         )
    }

    private fun convertEntityToADO(entity: AlcoEntity): AlcoDataObject{
        return AlcoDataObject(
            idDrink = entity.idDrink,
            strDrink = entity.strDrink,
            strDrinkThumb = entity.strDrinkThumb
        )
    }

    fun saveAlco(alcoEntity: AlcoEntity) {
       // Log.d("gopa save", alcoEntity.toString())
        Completable.fromRunnable {
            alcoDao.insert(alcoEntity)
        }
            .subscribeOn(Schedulers.io())
            .subscribe()

    }

}