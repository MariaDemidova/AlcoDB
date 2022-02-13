package demidova.alcodb.view.details

import demidova.alcodb.model.AlcoList
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface IDetailsViewFragment : MvpView {
    @AddToEndSingle
    fun loadAlco(alco: AlcoList)

    @Skip
    fun showError(message: String?)
}