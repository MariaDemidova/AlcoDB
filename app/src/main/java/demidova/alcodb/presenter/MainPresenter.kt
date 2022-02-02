package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import demidova.alcodb.model.Alco
import demidova.alcodb.model.Repository
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.main.MainView
import demidova.alcodb.view.main.MainViewFragment
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(private val router:Router): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AppScreens.alcoScreen())
    }

    fun onBackPressed() {
        router.exit()
    }
}