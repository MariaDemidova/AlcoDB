package demidova.alcodb.presenter

import android.util.Log
import com.github.terrakok.cicerone.Router
import demidova.alcodb.db.dao.AlcoDao
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.model.AlcoList
import demidova.alcodb.model.Repository
import demidova.alcodb.network.NetworkStatus
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.main.MainViewFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
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

        if (networkStatus.isOnline()) {
            repository.getAllAlcoholicCocktails()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ alcoList ->
                    val listADO = convertAlcoListToListADO(alcoList)
                    val listID = getListOfId(listADO)
                    val listADOWithId = getListADOFromRetrofit(listID)
                    viewState.updateList(listADOWithId)

                    Log.d("gopa","$listADOWithId" )
                    Log.d("gopa","$listID" )
                },
                    {
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

    private fun getListOfId(list: List<AlcoDataObject>): List<String> {
        val idList = mutableListOf<String>()
        list.forEach {
            idList.add(it.idDrink)
        }
        return idList
    }

    private fun getListADOFromRetrofit(list: List<String>): List<AlcoDataObject> {
        var listADO = mutableListOf<AlcoDataObject>()
        list.forEach {
            repository.getAlcoById(it)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ alcoList ->
                    alcoList.drinks.forEach { ADO->
                        listADO.add(ADO)
                    }
                },
                    { viewState.showError(it.message) })
        }

        return listADO
    }
}