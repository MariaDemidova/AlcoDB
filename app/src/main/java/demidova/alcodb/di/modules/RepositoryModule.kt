package demidova.alcodb.di.modules

import android.util.Log
import dagger.Module
import dagger.Provides
import demidova.alcodb.model.Repository
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.network.AlcoApiService
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun alcoRepo(alcoApiService: AlcoApiService): Repository {
        Log.d("popa", "alcoRepo module")
        return RepositoryImpl(alcoApiService)
    }
}