package demidova.alcodb.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import demidova.alcodb.App
import demidova.alcodb.databinding.FragmentDetailsBinding
import demidova.alcodb.model.Alco
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.presenter.AlcoPresenter
import demidova.alcodb.view.BackButtonListener
import demidova.alcodb.view.main.MainViewFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class DetailsFragment : MvpAppCompatFragment(), MainViewFragment, BackButtonListener {

    private val presenter by moxyPresenter { AlcoPresenter(RepositoryImpl(), App.instance.router) }

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val alco = arguments?.getParcelable<Alco>("alco")
        binding.nameDetails.text = alco?.name
        binding.imgDetails.setImageResource(alco!!.img)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
      return presenter.backPressed()
    }

    override fun updateList(alcos: List<Alco>) {

    }

}