package demidova.alcodb.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import demidova.alcodb.App
import demidova.alcodb.databinding.FragmentDetailsBinding
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.model.AlcoList
import demidova.alcodb.model.RepositoryImpl
import demidova.alcodb.network.ApiHolder
import demidova.alcodb.network.NetworkStatus
import demidova.alcodb.presenter.DetailsPresenter
import demidova.alcodb.utils.GlideImageLoader
import demidova.alcodb.view.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class DetailsFragment : MvpAppCompatFragment(), IDetailsViewFragment, BackButtonListener {

    val gladImg = GlideImageLoader()
    private val presenter by moxyPresenter {
        DetailsPresenter(
            RepositoryImpl(ApiHolder.alcoApiService),
            App.instance.router
        )
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
        val alco = arguments?.getParcelable<AlcoDataObject>("alco")

        alco?.let { presenter.loadData(it.idDrink) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }

    override fun loadAlco(alco: AlcoList) {
        alco.drinks.forEach {
            binding.nameDetails.text = it.strDrink
            binding.infoDetails.text = it.strInstructions
            it.strDrinkThumb?.let { gladImg.loadInto(it, binding.imgDetails) }
            binding.ingredient1.text = it.strIngredient1
            binding.ingredient2.text = it.strIngredient2
            binding.ingredient3.text = it.strIngredient3
            binding.ingredient4.text = it.strIngredient4
            binding.ingredient5.text = it.strIngredient5
            binding.ingredient6.text = it.strIngredient6
            binding.ingredient7.text = it.strIngredient7
            binding.ingredient8.text = it.strIngredient8
            binding.ingredient9.text = it.strIngredient9
            binding.ingredient10.text = it.strIngredient10
            binding.ingredient11.text = it.strIngredient11
            binding.ingredient12.text = it.strIngredient12
            binding.ingredient13.text = it.strIngredient13
            binding.ingredient14.text = it.strIngredient14
            binding.ingredient15.text = it.strIngredient15

            binding.measure1.text = it.strMeasure1
            binding.measure2.text = it.strMeasure2
            binding.measure3.text = it.strMeasure3
            binding.measure4.text = it.strMeasure4
            binding.measure5.text = it.strMeasure5
            binding.measure6.text = it.strMeasure6
            binding.measure7.text = it.strMeasure7
            binding.measure8.text = it.strMeasure8
            binding.measure9.text = it.strMeasure9
            binding.measure10.text = it.strMeasure10
            binding.measure11.text = it.strMeasure11
            binding.measure12.text = it.strMeasure12
            binding.measure13.text = it.strMeasure13
            binding.measure14.text = it.strMeasure14
            binding.measure15.text = it.strMeasure15
        }
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }
}