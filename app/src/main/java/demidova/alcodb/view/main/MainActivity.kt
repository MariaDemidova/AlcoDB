package demidova.alcodb.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import demidova.alcodb.R
import demidova.alcodb.databinding.ActivityMainBinding
import demidova.alcodb.view.main.MainFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}