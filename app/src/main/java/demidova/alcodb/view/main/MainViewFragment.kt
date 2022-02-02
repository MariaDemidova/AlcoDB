package demidova.alcodb.view.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MainViewFragment : MvpView {
    @AddToEndSingle
    fun showAlertDialog(name: String, position: Int)
}