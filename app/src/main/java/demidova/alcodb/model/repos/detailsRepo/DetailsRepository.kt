package demidova.alcodb.model.repos.detailsRepo

import demidova.alcodb.model.AlcoList
import io.reactivex.rxjava3.core.Single

interface DetailsRepository {

    fun getAlcoById(id: String): Single<AlcoList>
}