package demidova.alcodb.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import demidova.alcodb.App
import demidova.alcodb.databinding.FragmentMainBinding
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.utils.GlideImageLoader
import demidova.alcodb.view.BackButtonListener
import demidova.alcodb.view.adapter.AlcoAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MainFragment : MvpAppCompatFragment(), MainViewFragment, BackButtonListener {

    private val presenter by moxyPresenter {
        App.instance.appComponent.provideAlcoPresenter()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val alcoAdapter by lazy {
        AlcoAdapter(GlideImageLoader(), presenter::onUserClicked)
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


    override fun updateList(alcos: List<AlcoDataObject>) {
        alcoAdapter.submitList(alcos)
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }
}