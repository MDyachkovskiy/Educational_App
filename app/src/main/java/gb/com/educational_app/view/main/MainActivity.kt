package gb.com.educational_app.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import gb.com.educational_app.R
import gb.com.educational_app.databinding.ActivityMainBinding
import com.test.application.classes.view.ClassesFragment
import com.test.application.favorites.view.FavoritesFragment
import com.test.application.home.view.HomeFragment
import com.test.application.progress.view.ProgressFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .also{ setContentView(it.root) }

        if(savedInstanceState == null) {
            initHomeFragment()
        }

        initNavigationMenu()
    }

    private fun initNavigationMenu() {
        binding.navView.setOnItemSelectedListener {menuItem ->
            val fragment = when(menuItem) {
                R.id.navigation_home -> com.test.application.home.view.HomeFragment.newInstance()
                R.id.navigation_classes -> com.test.application.classes.view.ClassesFragment.newInstance()
                R.id.navigation_progress -> com.test.application.progress.view.ProgressFragment.newInstance()
                R.id.navigation_favorite -> com.test.application.favorites.view.FavoritesFragment.newInstance()
                else -> null
            }
            fragment?.let {
                replaceFragment(it)
                true
            } ?: false
        }
        binding.navView.setItemSelected(R.id.navigation_home, true)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .commitNow()
    }

    private fun initHomeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, com.test.application.home.view.HomeFragment.newInstance())
            .commitNow()
    }
}