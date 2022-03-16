package demidova.alcodb

import android.app.Application

import demidova.alcodb.di.modules.ContextModule
import demidova.alcodb.di.component.DaggerAppComponent

class App : Application() {

   val appComponent by lazy {
       DaggerAppComponent.builder()
           .contextModule(ContextModule(this))
           .build()
   }

    companion object {
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }
}