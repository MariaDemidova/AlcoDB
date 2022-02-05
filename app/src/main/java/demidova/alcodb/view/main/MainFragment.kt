package demidova.alcodb.view.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import demidova.alcodb.App
import demidova.alcodb.model.Alco
import demidova.alcodb.view.adapter.AlcoAdapter
import demidova.alcodb.R
import demidova.alcodb.databinding.FragmentMainBinding
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.presenter.AlcoPresenter
import demidova.alcodb.presenter.MainPresenter
import demidova.alcodb.view.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter

class MainFragment : MvpAppCompatFragment(), MainViewFragment, BackButtonListener {

    private val presenter by moxyPresenter { AlcoPresenter(RepositoryImpl(), App.instance.router)}

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val alcoAdapter by lazy {
        AlcoAdapter(presenter.alcoListPresenter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = alcoAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        alcoAdapter.notifyDataSetChanged()
    }
}