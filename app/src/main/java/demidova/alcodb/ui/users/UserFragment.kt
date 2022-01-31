package demidova.alcodb.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import demidova.alcodb.R
import demidova.alcodb.databinding.FragmentMainBinding
import demidova.alcodb.databinding.FragmentUserBinding
import demidova.alcodb.model.domain.UsersRepository
import demidova.alcodb.ui.users.adapter.UsersAdapter
import demidova.alcodb.view.main.MainFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UsersView {

    private val presenter by moxyPresenter { UserPresenter(UsersRepository()) }

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(presenter.userListPresenter)
    }

    companion object {
        fun newInstance() = UserFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_user, container,
            false
        )
        _binding = FragmentUserBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usersRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecycler.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

}