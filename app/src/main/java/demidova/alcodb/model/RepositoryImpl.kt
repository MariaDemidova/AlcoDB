package demidova.alcodb.model

class RepositoryImpl : Repository{
    override fun getAlcoList(): List<Alco> {
        return arrayListOf(
            Alco("Мартини"),
            Alco("Ром"),
            Alco("Текилла"),
            Alco("Водка с соком"),
            Alco("Пивной коктейль"),
            Alco("Боярышник с лимоном"),
            Alco("Вода из под крана"),
            Alco("Кровавая Мэри"),
            Alco("Кровавая Мэри"),
            Alco("Рябина на коньяке"),
        )
    }
}