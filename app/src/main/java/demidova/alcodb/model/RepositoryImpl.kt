package demidova.alcodb.model

import android.util.Log
import demidova.alcodb.network.AlcoApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class RepositoryImpl(private val alcoApiService: AlcoApiService) : Repository {
//    override fun getAlcoList(): Single<AlcoList> {
//        return alcoApiService.getAlcoholic(
//            "c535c84c68msheed3eab2c8e0efep1f0438jsn69a98f57184e",
//            "the-cocktail-db.p.rapidapi.com"
//        )
//    }

    override fun getAllAlcoholicCocktails( ): Single<AlcoList> {
//        var cocktail = CocktailResponse()
//        alcoApiService.getAlcoholicCocktails()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                cocktail = it
//            },
//                {
//                    it.printStackTrace()
//                }
//            )
//        var list = mutableListOf<AlcoDataObject>()
//        cocktail.drinks?.forEach {
//            var cocktailToAdd: AlcoDataObject =
//                alcoApiService.getCocktailById(it.idDrink).drinks!![0]
//            list.add(cocktailToAdd)
//        }
//        return list
        val a = alcoApiService.listAllCategoriesA().subscribeOn(Schedulers.io())
        Log.d("goper", " ${a}")
        return a
    }
}