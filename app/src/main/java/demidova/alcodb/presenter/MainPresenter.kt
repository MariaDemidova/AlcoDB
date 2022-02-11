package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.main.MainView
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