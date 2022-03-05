package demidova.alcodb.presenter

import android.util.Log
import com.github.terrakok.cicerone.Router
import demidova.alcodb.cache.DetailsCache
import demidova.alcodb.db.dao.AlcoDao
import demidova.alcodb.db.entity.AlcoEntity
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.model.AlcoList
import demidova.alcodb.model.Repository
import demidova.alcodb.network.NetworkStatus
import demidova.alcodb.view.details.IDetailsViewFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class DetailsPresenter(
    private val repository: Repository,
    private val router: Router,
    private val alcoDao: AlcoDao,
    private val networkStatus: NetworkStatus
) :
    MvpPresenter<IDetailsViewFragment>(), DetailsCache {

    fun loadData(id: String) {
        if (networkStatus.isOnline()) {
            repository.getAlcoById(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("gopa det", "${convertAlcoListToADO(it)}")
                    val ado = convertAlcoListToADO(it)
                    viewState.loadAlco(ado)
                    cacheDrtails(convertADOToEntity(ado))
                },
                    {

                        viewState.showError(it.message)
                    })
        } else {
            alcoDao.getCocktailById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.loadAlco(convertEntityToADO(it))
                }, {

                    viewState.showError(it.message)
                })
        }
    }

    private fun convertADOToEntity(alcoDataObject: AlcoDataObject): AlcoEntity {
        return AlcoEntity(
            idDrink = alcoDataObject.idDrink,
            strInstructions = alcoDataObject.strInstructions,
            strDrink = alcoDataObject.strDrink,
            strDrinkThumb = alcoDataObject.strDrinkThumb,

            strIngredient1 = alcoDataObject.strIngredient1,
            strIngredient2 = alcoDataObject.strIngredient2,
            strIngredient3 = alcoDataObject.strIngredient3,
            strIngredient4 = alcoDataObject.strIngredient4,
            strIngredient5 = alcoDataObject.strIngredient5,
            strIngredient6 = alcoDataObject.strIngredient6,
            strIngredient7 = alcoDataObject.strIngredient7,
            strIngredient8 = alcoDataObject.strIngredient8,
            strIngredient9 = alcoDataObject.strIngredient9,
            strIngredient10 = alcoDataObject.strIngredient10,
            strIngredient11 = alcoDataObject.strIngredient11,
            strIngredient12 = alcoDataObject.strIngredient12,
            strIngredient13 = alcoDataObject.strIngredient13,
            strIngredient14 = alcoDataObject.strIngredient14,
            strIngredient15 = alcoDataObject.strIngredient15,
            strMeasure1 = alcoDataObject.strMeasure1,
            strMeasure2 = alcoDataObject.strMeasure2,
            strMeasure3 = alcoDataObject.strMeasure3,
            strMeasure4 = alcoDataObject.strMeasure4,
            strMeasure5 = alcoDataObject.strMeasure5,
            strMeasure6 = alcoDataObject.strMeasure6,
            strMeasure7 = alcoDataObject.strMeasure7,
            strMeasure8 = alcoDataObject.strMeasure8,
            strMeasure9 = alcoDataObject.strMeasure9,
            strMeasure10 = alcoDataObject.strMeasure10,
            strMeasure11 = alcoDataObject.strMeasure11,
            strMeasure12 = alcoDataObject.strMeasure12,
            strMeasure13 = alcoDataObject.strMeasure13,
            strMeasure14 = alcoDataObject.strMeasure14,
            strMeasure15 = alcoDataObject.strMeasure15
        )
    }



    private fun convertEntityToADO(alcoEntity: AlcoEntity): AlcoDataObject {
        return AlcoDataObject(
            idDrink = alcoEntity.idDrink,
            strInstructions = alcoEntity.strInstructions,
            strDrink = alcoEntity.strDrink,
            strDrinkThumb = alcoEntity.strDrinkThumb,

            strIngredient1 = alcoEntity.strIngredient1,
            strIngredient2 = alcoEntity.strIngredient2,
            strIngredient3 = alcoEntity.strIngredient3,
            strIngredient4 = alcoEntity.strIngredient4,
            strIngredient5 = alcoEntity.strIngredient5,
            strIngredient6 = alcoEntity.strIngredient6,
            strIngredient7 = alcoEntity.strIngredient7,
            strIngredient8 = alcoEntity.strIngredient8,
            strIngredient9 = alcoEntity.strIngredient9,
            strIngredient10 = alcoEntity.strIngredient10,
            strIngredient11 = alcoEntity.strIngredient11,
            strIngredient12 = alcoEntity.strIngredient12,
            strIngredient13 = alcoEntity.strIngredient13,
            strIngredient14 = alcoEntity.strIngredient14,
            strIngredient15 = alcoEntity.strIngredient15,
            strMeasure1 = alcoEntity.strMeasure1,
            strMeasure2 = alcoEntity.strMeasure2,
            strMeasure3 = alcoEntity.strMeasure3,
            strMeasure4 = alcoEntity.strMeasure4,
            strMeasure5 = alcoEntity.strMeasure5,
            strMeasure6 = alcoEntity.strMeasure6,
            strMeasure7 = alcoEntity.strMeasure7,
            strMeasure8 = alcoEntity.strMeasure8,
            strMeasure9 = alcoEntity.strMeasure9,
            strMeasure10 = alcoEntity.strMeasure10,
            strMeasure11 = alcoEntity.strMeasure11,
            strMeasure12 = alcoEntity.strMeasure12,
            strMeasure13 = alcoEntity.strMeasure13,
            strMeasure14 = alcoEntity.strMeasure14,
            strMeasure15 = alcoEntity.strMeasure15
        )
    }

    private fun convertAlcoListToADO(alcoList: AlcoList): AlcoDataObject {
        val listADO = mutableListOf<AlcoDataObject>()
        alcoList.drinks.forEach {
            listADO.add(it)
        }
        return listADO[0]
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun cacheDrtails(entity: AlcoEntity) {
        Completable.fromRunnable {
            alcoDao.insert(entity)
        }
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

}