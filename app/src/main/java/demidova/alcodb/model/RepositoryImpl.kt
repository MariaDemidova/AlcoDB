package demidova.alcodb.model

import demidova.alcodb.network.AlcoApiService
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


class RepositoryImpl(private val alcoApiService: AlcoApiService) : Repository{
    override fun getAlcoList(): Single<Alco> {
        return alcoApiService.getAlcoholic("c535c84c68msheed3eab2c8e0efep1f0438jsn69a98f57184e", "the-cocktail-db.p.rapidapi.com")
    }

}