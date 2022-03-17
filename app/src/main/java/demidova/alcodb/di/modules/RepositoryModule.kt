package demidova.alcodb.di.modules

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import demidova.alcodb.model.repos.alcoRepo.AlcoRepository
import demidova.alcodb.model.repos.alcoRepo.AlcoRepositoryImpl
import demidova.alcodb.model.repos.detailsRepo.DetailsRepository
import demidova.alcodb.model.repos.detailsRepo.DetailsRepositoryImpl
import demidova.alcodb.network.AlcoApiService
import javax.inject.Singleton

@Module
interface RepositoryModule {

//    @Provides
//    @Singleton
//    fun alcoRepo(alcoApiService: AlcoApiService): AlcoRepository {
//        Log.d("popa", "alcoRepo module")
//        return AlcoRepositoryImpl(alcoApiService)
//    }
    @Binds
    @Singleton
    fun provideAlcoRepository(impl: AlcoRepositoryImpl): AlcoRepository

    @Binds
    @Singleton
    fun provideDetailsRepository(impl: DetailsRepositoryImpl): DetailsRepository
}