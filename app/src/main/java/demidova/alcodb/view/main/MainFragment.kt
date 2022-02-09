package demidova.alcodb.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import demidova.alcodb.App
import demidova.alcodb.databinding.FragmentMainBinding
import demidova.alcodb.model.Alco
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.presenter.AlcoPresenter
import demidova.alcodb.view.BackButtonListener
import demidova.alcodb.view.adapter.AlcoAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MainFragment : MvpAppCompatFragment(), MainViewFragment, BackButtonListener {

    private val presenter by moxyPresenter { AlcoPresenter(RepositoryImpl(), App.instance.router) }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val alcoAdapter by lazy {
        AlcoAdapter(presenter::onUserClicked)
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

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        binding.recyclerView.adapter = alcoAdapter

        binding.btnGoToImgConverter.setOnClickListener { presenter.goToImageConverter() }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean = presenter.backPressed()


    override fun updateList(alcos: List<Alco>) {
        alcoAdapter.submitList(alcos)
    }
}