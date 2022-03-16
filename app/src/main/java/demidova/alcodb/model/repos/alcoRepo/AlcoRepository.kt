package demidova.alcodb.model.repos.alcoRepo

import demidova.alcodb.model.AlcoList
import io.reactivex.rxjava3.core.Single

interface AlcoRepository {

    fun getAllAlcoholicCocktails(): Single<AlcoList>
}