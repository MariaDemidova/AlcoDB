package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import demidova.alcodb.model.Repository
import demidova.alcodb.view.details.IDetailsViewFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class DetailsPresenter(private val repository: Repository, private val router: Router) :
    MvpPresenter<IDetailsViewFragment>() {

    fun loadData(id: String) {
        repository.getAlcoById(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.loadAlco(it)
            },
                {

                    viewState.showError(it.message)
                })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}