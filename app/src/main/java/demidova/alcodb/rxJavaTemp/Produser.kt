package demidova.alcodb.rxJavaTemp

import demidova.alcodb.model.Alco
import demidova.alcodb.model.RepositoryImpl
import io.reactivex.rxjava3.core.Observable


class Produser {
    val repository = RepositoryImpl()
    val listAlcos = repository.getAlcoList()
    fun iterable(): Observable<Alco> {
        return Observable.fromIterable(listAlcos)
    }
}

