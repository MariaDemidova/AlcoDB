package demidova.alcodb.view.main

import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.model.AlcoList
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface MainViewFragment : MvpView {
    @AddToEndSingle
    fun updateList(alcos: List<AlcoDataObject>)

    @Skip
    fun showError(message: String?)
}