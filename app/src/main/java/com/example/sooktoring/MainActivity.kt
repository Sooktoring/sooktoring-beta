package com.example.sooktoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sooktoring.databinding.ActivityLoginBinding
import com.example.sooktoring.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentOne = Fragment_1()
    private val fragmentTwo = Fragment_2()
    private val fragmentThree = Fragment_3()
    private val fragmentFour = Fragment_4()

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        initNavigationBar()
    }

    private fun initNavigationBar() {
        binding.bottomNavigation
        bottom_navigation.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.nav_1-> {
                        changeFragment(fragmentOne)
                    }
                    R.id.nav_2-> {
                        changeFragment(fragmentTwo)
                    }
                    R.id.nav_3 -> {
                        changeFragment(fragmentThree)
                    }
                    R.id.nav_4 -> {
                        changeFragment(fragmentFour)
                    }
                }
                true
            }
            selectedItemId = R.id.nav_1 }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.bottom_navigation, fragment)
            .commit()
    }
}