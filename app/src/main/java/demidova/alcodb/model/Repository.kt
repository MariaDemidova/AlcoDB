package demidova.alcodb.model

import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getAlcoList(): Single<Alco>
}