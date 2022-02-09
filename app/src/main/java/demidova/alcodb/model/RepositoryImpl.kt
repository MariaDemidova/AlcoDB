package demidova.alcodb.model

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable


class RepositoryImpl : Repository{
    override fun getAlcoList(): @NonNull Observable<ArrayList<Alco>>? {
        return Observable.just(arrayListOf(
            Alco("Мартини"),
            Alco("Ром"),
            Alco("Текилла"),
            Alco("Водка с соком"),
            Alco("Пивной коктейль"),
            Alco("Боярышник с лимоном"),
            Alco("Вода из под крана"),
            Alco("Кровавая Мэри"),
            Alco("Рябина на коньяке"),
        ))
    }
}