package demidova.alcodb.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import demidova.alcodb.App
import demidova.alcodb.model.Alco
import demidova.alcodb.view.adapter.AlcoAdapter
import demidova.alcodb.R
import demidova.alcodb.databinding.FragmentMainBinding
import demidova.alcodb.presenter.MainPresenter
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter

class MainFragment : MvpAppCompatFragment(), MainViewFragment {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val alcoAdapter: AlcoAdapter by lazy {
        AlcoAdapter()
    }


    private val presenter by moxyPresenter { MainPresenter(App.instance.router)}

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
//В дальнейшем будет открываться новый фрагмент с подгружаемыи ингридиентами и картинкой
            showAlertDialog(alco.name, position)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showAlertDialog(name: String, position: Int) {
        AlertDialog.Builder(requireContext())
            .setTitle("${name} ${presenter.counterClick(position)}")
            .setMessage("Потом тут откроется фрагмент с деталями")
            .create()
            .show()
    }
}