package demidova.alcodb.model

import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getAllAlcoholicCocktails(): Single<AlcoList>

    fun getAlcoById(id: String): Single<AlcoList>
}