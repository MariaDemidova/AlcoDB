package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.model.Repository
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.main.MainViewFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlcoPresenter(private val repository: Repository, private val router: Router) :
    MvpPresenter<MainViewFragment>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {

        var listDTO = mutableListOf<AlcoDataObject>()
        repository.getAllAlcoholicCocktails()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ alcoList ->
                alcoList.drinks.forEach {
                    listDTO.add(it)
                }
                viewState.updateList(listDTO)
            },
                {


                    viewState.showError(it.message)
                })
    }

    fun onUserClicked(alco: AlcoDataObject) {
        router.navigateTo(AppScreens.detailsScreen(alco))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun goToImageConverter() {
        router.navigateTo(AppScreens.imageConverter())
    }

}