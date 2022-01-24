package demidova.alcodb.model

interface Repository {
    fun getAlcoList(): List<Alco>
}