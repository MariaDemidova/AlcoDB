package demidova.alcodb.model

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable

interface Repository {
    fun getAlcoList(): @NonNull Observable<ArrayList<Alco>>?
}