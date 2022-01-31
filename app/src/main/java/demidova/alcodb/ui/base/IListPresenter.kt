package demidova.alcodb.ui.base

interface IListPresenter<V : IItemView> {
    var itemOnClickListener: () ->Unit
    fun getCount(): Int
    fun bindView(view: V)
}