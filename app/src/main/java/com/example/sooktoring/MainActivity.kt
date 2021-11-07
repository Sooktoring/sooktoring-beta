package com.example.sooktoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import com.example.sooktoring.Message.ChatListActivity
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

        /*binding.chatBtn.setOnClickListener {
            startActivity(Intent(this, ChatListActivity::class.java))
        }*/

    }


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