package demidova.alcodb.model.repos.alcoRepo

import demidova.alcodb.model.AlcoList
import demidova.alcodb.network.AlcoApiService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AlcoRepositoryImpl @Inject constructor(
    private val alcoApiService: AlcoApiService,

    ) : AlcoRepository {
    override fun getAllAlcoholicCocktails(): Single<AlcoList> {
        return alcoApiService.listAllCategoriesA().subscribeOn(Schedulers.io())
    }

}


