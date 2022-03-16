package demidova.alcodb.screens

import androidx.core.os.bundleOf
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import demidova.alcodb.imgConverter.ImgConverterFragment
import demidova.alcodb.model.AlcoDataObject
import demidova.alcodb.view.details.DetailsFragment
import demidova.alcodb.view.main.MainFragment

interface IAppScreens{
    fun alcoScreen(): Screen
    fun detailsScreen(alco: AlcoDataObject): Screen
    fun imageConverter(): Screen
}

class AppScreens : IAppScreens {

   override fun alcoScreen(): Screen {
        return FragmentScreen { MainFragment() }
    }

    override fun detailsScreen(alco: AlcoDataObject): Screen {
        return FragmentScreen {
            DetailsFragment().apply {
                arguments = bundleOf("alco" to alco, )
            }
        }
    }

    override fun imageConverter(): Screen =
        FragmentScreen { ImgConverterFragment() }
}
