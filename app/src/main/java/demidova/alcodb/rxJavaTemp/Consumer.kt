package demidova.alcodb.rxJavaTemp

import android.util.Log

class Consumer(){
    private val produser = Produser()
    fun subscribe(){
        produser.iterable()
            ?.subscribe(
                {
                    Log.d("observe", "получили команду ${it.name}")
                },
                {
                    Log.e("observe", "получили ошибку $it", it)
                },
                {
                    Log.d("observe", "все закончилось")
                },
            )
    }
}