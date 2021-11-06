package com.example.sooktoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import com.example.sooktoring.Tab.MainTabFragment
import com.example.sooktoring.databinding.ActivityMainBinding
import com.example.sooktoring.navigation.AlarmFragment
import com.example.sooktoring.navigation.ChatFragment
import com.example.sooktoring.navigation.HomeFragment
import com.example.sooktoring.navigation.MyPageFragment
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

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

        binding.bottomNavigation.setOnItemSelectedListener(this)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        binding.bottomNavigation.selectedItemId = R.id.action_home

//        initNavigationBar()
    }

//    private fun initNavigationBar() {
//        bottom_navigation.run {
//            setOnNavigationItemSelectedListener {
//                when(it.itemId) {
//                    R.id.action_home-> {
//                        changeFragment(Frag)
//                    }
//                    R.id.action_chat-> {
//                        changeFragment(fragmentTwo)
//                    }
//                    R.id.action_alarm -> {
//                        changeFragment(Fragment_3())
//                    }
//                    R.id.action_mypage -> {
//                        changeFragment(Fragment_4)
//                    }
//                }
//                true
//            }
//            selectedItemId = R.id.action_home }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_home->{
                var mainTabFragment = MainTabFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, mainTabFragment).commit()
                return true
            }
            R.id.action_chat->{
                var chatFragment = ChatFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, chatFragment).commit()
                return true
            }
            R.id.action_alarm->{
                var alarmFragment = AlarmFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, alarmFragment).commit()
                return true
            }
            R.id.action_mypage->{
                var myPageFragment = MyPageFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, myPageFragment).commit()
                return true
            }
        }
        return false
    }
}