package demidova.alcodb.model

import demidova.alcodb.network.AlcoApiService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class RepositoryImpl(private val alcoApiService: AlcoApiService) : Repository {

    override fun getAllAlcoholicCocktails(): Single<AlcoList> {
        return alcoApiService.listAllCategoriesA().subscribeOn(Schedulers.io())
    }

    override fun getAlcoById(idDrink: String): Single<AlcoList> {
        return alcoApiService.getCocktailById(idDrink).subscribeOn(Schedulers.io())
    }
}