package demidova.alcodb.presenter

import demidova.alcodb.model.Alco
import demidova.alcodb.view.IItemView

interface IListPresenter<V : IItemView> {

    var itemClickListener: () -> Unit

    fun getCount(): Int

    fun bindView(view: V)
}