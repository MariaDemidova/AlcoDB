package demidova.alcodb.di.component

import dagger.Component
import demidova.alcodb.di.modules.*

import demidova.alcodb.presenter.AlcoPresenter
import demidova.alcodb.presenter.AlcoPresenterFactory
import demidova.alcodb.presenter.DetailsPresenter
import demidova.alcodb.presenter.MainPresenter
import demidova.alcodb.view.main.MainActivity
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        NavigationModule::class,
        DbModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface AppComponent {
    fun provideMainPresenter(): MainPresenter

    fun provideAlcoPresenter(): AlcoPresenter

    fun provideAlcoPresenterFactory(): AlcoPresenterFactory

    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(alcoPresenter: AlcoPresenter)

    fun inject(detailsPresenter: DetailsPresenter)
}