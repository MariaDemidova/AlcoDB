package demidova.alcodb.network

import demidova.alcodb.model.AlcoList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AlcoApiService {

    @GET("filter.php?a=Alcoholic")
    fun listAllCategoriesA(): Single<AlcoList>

    @GET("lookup.php?")
    fun getCocktailById(@Query("i") id: String): Single<AlcoList>
}