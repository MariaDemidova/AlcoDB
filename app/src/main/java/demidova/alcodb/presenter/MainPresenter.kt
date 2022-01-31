package demidova.alcodb.presenter

import demidova.alcodb.model.Alco
import demidova.alcodb.model.Repository
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.view.main.MainView
import moxy.InjectViewState
import moxy.MvpPresenter
@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    private val repository: Repository = RepositoryImpl()
    private val countList = Array(getListOfAlco().size) { 1 }

    fun counterClick(position: Int): Int {
        return countList[position]++
    }

    fun getListOfAlco(): List<Alco> {
        return repository.getAlcoList()
    }
}