package demidova.alcodb.network

import demidova.alcodb.model.AlcoList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface AlcoApiService {

    //   alcoholic drinks
//    @GET("filter.php?a=Alcoholic")
//    fun getAlcoholic(
//        @Header("x-rapidapi-key") apiKey: String,
//        @Header("x-rapidapi-host") host: String
//    ): Single<Alco>

//    @Headers("Content-Type: application/json")
//    @GET("filter.php?a=Alcoholic")
//     fun getAlcoholicCocktails(): Single< CocktailResponse>

    @GET("filter.php?a=Alcoholic")

    fun listAllCategoriesA(): Single<AlcoList>
}