package demidova.alcodb.utils

interface ImageLoader<T> {
    fun loadInto(url: String, container: T)
}
