package demidova.alcodb.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import demidova.alcodb.model.Alco
import demidova.alcodb.view.adapter.AlcoAdapter
import demidova.alcodb.R
import demidova.alcodb.databinding.FragmentMainBinding
import demidova.alcodb.presenter.MainPresenter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val alcoAdapter: AlcoAdapter by lazy {
        AlcoAdapter()
    }

    private val presenter = MainPresenter()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_main, container,
            false
        )

        _binding = FragmentMainBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = alcoAdapter
        alcoAdapter.setData(presenter.getListOfAlco())
        
        alcoAdapter.listener = AlcoAdapter.OnItemViewClickListener { alco, position ->

            AlertDialog.Builder(requireContext())
                .setTitle("${alco.name} ${presenter.counterClick(position)}")
                .setMessage("Потом тут откроется фрагмент с деталями")
                .create()
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}