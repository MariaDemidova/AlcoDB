package demidova.alcodb.model

class RepositoryImpl : Repository{
    override fun getAlcoList(): List<Alco> {
        // В дальнейшем данные будут подгружаться через ретрофит из https://www.thecocktaildb.com/api.php,
        return arrayListOf(
            Alco("Мартини"),
            Alco("Ром"),
            Alco("Текилла"),
            Alco("Водка с соком"),
            Alco("Пивной коктейль"),
            Alco("Боярышник с лимоном"),
            Alco("Вода из под крана"),
            Alco("Кровавая Мэри")
        )
    }
}