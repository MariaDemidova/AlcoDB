package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import demidova.alcodb.App
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.screens.IAppScreens
import demidova.alcodb.view.main.MainView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private var router: Router,
    private var screens: IAppScreens
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.alcoScreen())
    }

    fun onBackPressed() {
        router.exit()
    }
}