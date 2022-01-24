package demidova.alcodb.presenter

import demidova.alcodb.model.Alco
import demidova.alcodb.model.Repository
import demidova.alcodb.model.RepositoryImpl

class MainPresenter {

    private val repository: Repository = RepositoryImpl()
    private val countList = Array(getListOfAlco().size) { 1 }

    fun counterClick(position: Int): Int {
        return countList[position]++
    }

    fun getListOfAlco(): List<Alco> {
        return repository.getAlcoList()
    }


}