package demidova.alcodb.model.repos.detailsRepo

import android.util.Log
import demidova.alcodb.model.AlcoList
import demidova.alcodb.network.AlcoApiService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val alcoApiService: AlcoApiService,

    ) : DetailsRepository {

    override fun getAlcoById(idDrink: String): Single<AlcoList> {
        return alcoApiService.getCocktailById(idDrink).subscribeOn(Schedulers.io())
    }

}


