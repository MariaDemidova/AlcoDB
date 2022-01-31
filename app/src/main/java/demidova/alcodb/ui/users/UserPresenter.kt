package demidova.alcodb.ui.users

import demidova.alcodb.model.UserModel
import demidova.alcodb.model.domain.UsersRepository
import demidova.alcodb.ui.base.IListPresenter
import moxy.MvpPresenter

class UserPresenter(val usersRepository: UsersRepository) : MvpPresenter<UsersView>() {

    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
        userListPresenter.itemOnClickListener = {}
    }

    private fun loadData() {
        val users = usersRepository.getUsers()
        userListPresenter.users.addAll(users)

        viewState.updateList()
    }

    class UserListPresenter : IListPresenter<UserItemView> {
        val users = mutableListOf<UserModel>()

        override var itemOnClickListener: () -> Unit = {}

        override fun getCount(): Int {
            return users.size
        }

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}