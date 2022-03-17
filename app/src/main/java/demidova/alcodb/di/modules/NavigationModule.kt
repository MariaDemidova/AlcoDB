package demidova.alcodb.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.screens.IAppScreens
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideCicerone(): Cicerone<Router>{
        return Cicerone.create()
    }

    @Provides
    @Singleton
    fun providesNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    @Singleton
    fun providerRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    @Singleton
    fun provideAppScreens(): IAppScreens{
        return AppScreens()
    }
}