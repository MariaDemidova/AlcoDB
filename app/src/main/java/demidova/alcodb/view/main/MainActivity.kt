package demidova.alcodb.view.main

import android.os.Bundle
import android.os.PersistableBundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import demidova.alcodb.App
import demidova.alcodb.R
import demidova.alcodb.databinding.ActivityMainBinding
import demidova.alcodb.presenter.MainPresenter
import demidova.alcodb.view.BackButtonListener
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import java.util.zip.Inflater

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router)
    }

    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.instance.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.onBackPressed()
    }
}