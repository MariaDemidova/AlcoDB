package demidova.alcodb.ui.users

import demidova.alcodb.ui.base.IItemView

interface UserItemView: IItemView {
    fun setLogin(login:String)
}