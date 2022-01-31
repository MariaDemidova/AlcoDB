package demidova.alcodb.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import demidova.alcodb.databinding.ItemUsersBinding
import demidova.alcodb.model.UserModel
import demidova.alcodb.ui.base.IItemView
import demidova.alcodb.ui.base.IListPresenter
import demidova.alcodb.ui.users.UserItemView
import demidova.alcodb.ui.users.UserPresenter

class UsersAdapter(
    private val presenter: UserPresenter.UserListPresenter
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    inner class UserViewHolder(private val vb: ItemUsersBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemView {
        override var pos: Int = -1

        override fun setLogin(login: String) {
            vb.tvLogin.text = login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUsersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemOnClickListener() }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }
}