package demidova.alcodb.view.main

import com.github.terrakok.cicerone.androidx.AppNavigator
import demidova.alcodb.App
import demidova.alcodb.R
import demidova.alcodb.presenter.MainPresenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    val navigator = AppNavigator(this, R.id.container)

    val presenter by moxyPresenter {
        MainPresenter(App.instance.router)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.instance.navigatorHolder.removeNavigator()
        super.onPause()
    }
}