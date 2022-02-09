package demidova.alcodb.view.main

import demidova.alcodb.model.Alco
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MainViewFragment : MvpView {
    @AddToEndSingle
    fun updateList(alcos: List<Alco>)
}