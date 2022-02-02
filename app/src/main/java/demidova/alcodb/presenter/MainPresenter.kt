package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import demidova.alcodb.model.Alco
import demidova.alcodb.model.Repository
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.main.MainViewFragment
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(val router:Router): MvpPresenter<MainViewFragment>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(AppScreens.alcoScreen())
    }

    private val repository: Repository = RepositoryImpl()
    private val countList = Array(getListOfAlco().size) { 1 }

    fun counterClick(position: Int): Int {
        return countList[position]++
    }

    fun getListOfAlco(): List<Alco> {
        return repository.getAlcoList()

    }

    fun onBackPressed() {
        router.exit()
    }
}