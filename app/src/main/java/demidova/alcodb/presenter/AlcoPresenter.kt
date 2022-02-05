package demidova.alcodb.presenter

import com.github.terrakok.cicerone.Router
import demidova.alcodb.model.Alco
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.screens.AppScreens
import demidova.alcodb.view.AlcoItemView
import demidova.alcodb.view.main.MainViewFragment
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlcoPresenter(val repository: RepositoryImpl, private val router: Router) :
    MvpPresenter<MainViewFragment>() {

    val alcoListPresenter = AlcoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()

        alcoListPresenter.itemClickListener = {
            router.navigateTo(AppScreens.detailsScreen(alcoListPresenter.alcos[it.pos]))
        }
    }

    private fun loadData() {
        val alco = repository.getAlcoList()
        alcoListPresenter.alcos.addAll(alco)

        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    class AlcoListPresenter : IListPresenter<AlcoItemView> {

        val alcos = mutableListOf<Alco>()

        override  var itemClickListener: (AlcoItemView) -> Unit = {}


        override fun getCount() = alcos.size

        override fun bindView(view: AlcoItemView) {
            val alco = alcos[view.pos]
            view.setName(alco.name)
            view.setImg(alco.img)

        }
    }
}