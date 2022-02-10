package demidova.alcodb.presenter

import android.util.Log
import com.github.terrakok.cicerone.Router
import demidova.alcodb.model.Alco
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.model.Repository
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.details.DetailsFragment
import demidova.alcodb.view.main.MainViewFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlcoPresenter(val repository: Repository, private val router: Router) :
    MvpPresenter<MainViewFragment>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        repository.getAlcoList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("gopa", it.toString())
                viewState.updateList(it.drinks)
            },
                {
                    Log.d("gopaer", it.toString())

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