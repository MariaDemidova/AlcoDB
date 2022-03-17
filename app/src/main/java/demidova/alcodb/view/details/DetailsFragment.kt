package demidova.alcodb.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import demidova.alcodb.App
import demidova.alcodb.databinding.FragmentDetailsBinding
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.utils.GlideImageLoader
import demidova.alcodb.view.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import android.util.Log


class DetailsFragment : MvpAppCompatFragment(), IDetailsViewFragment, BackButtonListener {

    val gladImg = GlideImageLoader()
    private val presenter by moxyPresenter {
        val alco = arguments?.getParcelable<AlcoDataObject>("alco")
        App.instance.appComponent.provideAlcoPresenterFactory().presenter(alco!!.idDrink)

    }

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

        presenter.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    override fun loadAlco(ado: AlcoDataObject) {

        binding.nameDetails.text = ado.strDrink
        binding.infoDetails.text = ado.strInstructions
        ado.strDrinkThumb.let { gladImg.loadInto(it, binding.imgDetails) }
        binding.ingredient1.text = ado.strIngredient1
        binding.ingredient2.text = ado.strIngredient2
        binding.ingredient3.text = ado.strIngredient3
        binding.ingredient4.text = ado.strIngredient4
        binding.ingredient5.text = ado.strIngredient5
        binding.ingredient6.text = ado.strIngredient6
        binding.ingredient7.text = ado.strIngredient7
        binding.ingredient8.text = ado.strIngredient8
        binding.ingredient9.text = ado.strIngredient9
        binding.ingredient10.text = ado.strIngredient10
        binding.ingredient11.text = ado.strIngredient11
        binding.ingredient12.text = ado.strIngredient12
        binding.ingredient13.text = ado.strIngredient13
        binding.ingredient14.text = ado.strIngredient14
        binding.ingredient15.text = ado.strIngredient15

        binding.measure1.text = ado.strMeasure1
        binding.measure2.text = ado.strMeasure2
        binding.measure3.text = ado.strMeasure3
        binding.measure4.text = ado.strMeasure4
        binding.measure5.text = ado.strMeasure5
        binding.measure6.text = ado.strMeasure6
        binding.measure7.text = ado.strMeasure7
        binding.measure8.text = ado.strMeasure8
        binding.measure9.text = ado.strMeasure9
        binding.measure10.text = ado.strMeasure10
        binding.measure11.text = ado.strMeasure11
        binding.measure12.text = ado.strMeasure12
        binding.measure13.text = ado.strMeasure13
        binding.measure14.text = ado.strMeasure14
        binding.measure15.text = ado.strMeasure15
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }
}
