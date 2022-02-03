package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppScreen
import demidova.alcodb.model.Alco
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.details.DetailsFragment
import demidova.alcodb.view.main.MainViewFragment
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlcoPresenter(val repository: RepositoryImpl, private val router: Router) :
    MvpPresenter<MainViewFragment>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        val alcos = repository.getAlcoList()

        viewState.updateList(alcos)
    }

    fun onUserClicked(alco: Alco) {
        router.navigateTo(AppScreens.detailsScreen(alco))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}