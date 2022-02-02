package demidova.alcodb.screens

import androidx.core.os.bundleOf
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import demidova.alcodb.model.Alco
import demidova.alcodb.view.details.DetailsFragment
import demidova.alcodb.view.main.MainFragment

object AppScreens {

    fun alcoScreen(): Screen{
        return FragmentScreen { MainFragment()}
    }
//
//    fun detailsScreen(alco: Alco): Screen{
//        return FragmentScreen { DetailsFragment().apply {
//            arguments = bundleOf("alco" to alco)
//        } }
//    }


    fun detailsScreen( ): Screen{
        return FragmentScreen { DetailsFragment() }
    }
}