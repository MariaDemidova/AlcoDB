package demidova.alcodb

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import demidova.alcodb.db.AlcoDataBase

class App : Application() {

    companion object {
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    val dataBase by lazy {
        AlcoDataBase.getInstance(this)
    }

    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }
}