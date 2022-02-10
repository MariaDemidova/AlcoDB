package demidova.alcodb.network

import demidova.alcodb.model.Alco
import demidova.alcodb.model.AlcoDataObject
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface AlcoApiService {

    //   alcoholic drinks
    @GET("/filter.php?a=Alcoholic")
    fun getAlcoholic(@Header("x-rapidapi-key") apiKey: String,
                     @Header("x-rapidapi-host")  host: String
    ): Single<Alco>

}