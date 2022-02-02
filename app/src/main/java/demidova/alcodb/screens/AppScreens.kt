package demidova.alcodb.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import demidova.alcodb.ui.users.UserFragment
import demidova.alcodb.view.main.MainFragment

object AppScreens {
    fun usersScreen() = FragmentScreen{
        UserFragment()
    }

    fun alcoScreen() = FragmentScreen{
        MainFragment()
    }
}