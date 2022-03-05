package demidova.alcodb.view.details

import demidova.alcodb.model.AlcoDataObject
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface IDetailsViewFragment : MvpView {
    @AddToEndSingle
    fun loadAlco(ado: AlcoDataObject)

    @Skip
    fun showError(message: String?)
}