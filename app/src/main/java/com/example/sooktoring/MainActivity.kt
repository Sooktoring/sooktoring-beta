package com.example.sooktoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.sooktoring.Tab.MainClubFragment
import com.example.sooktoring.Tab.MainContestFragment
import com.example.sooktoring.Tab.MainMentoringFragment
import com.example.sooktoring.Tab.MainTabFragment
import com.example.sooktoring.databinding.ActivityMainBinding
import com.example.sooktoring.navigation.AlarmFragment
import com.example.sooktoring.navigation.ChatFragment
import com.example.sooktoring.navigation.HomeFragment
import com.example.sooktoring.navigation.MyPageFragment
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.core.ActivityScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tab_layout
import kotlinx.android.synthetic.main.main_tab_fragment.*

class MainActivity : BaseActivity(), NavigationBarView.OnItemSelectedListener {

    override var viewId: Int = R.layout.activity_main
    override var toolbarId: Int? = R.id.toolbar

    override fun onCreate() {
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.bottomNavigation.setOnItemSelectedListener(this)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        binding.bottomNavigation.selectedItemId = R.id.action_home

        //View Pager
        mViewPager = binding.viewPager
        mViewPager!!.adapter = PagerAdapter(supportFragmentManager)
        mViewPager!!.currentItem = 0

        tab_layout.setupWithViewPager(mViewPager)

        tab_layout.getTabAt(0)!!.text = "멘토링"
        tab_layout.getTabAt(1)!!.text = "동아리"
        tab_layout.getTabAt(2)!!.text = "공모전"

        mViewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.select()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

    }
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private var mViewPager: ViewPager? = null

    var auth: FirebaseAuth? = null

    inner class PagerAdapter(supportFragment: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager) {
        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 ->
                    MainMentoringFragment()
                1 ->
                    MainClubFragment()
                2 ->
                    MainContestFragment()
                else ->
                    MainMentoringFragment()
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_home->{
                var mainTabFragment = MainTabFragment()
                binding.appBarlayout.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction().replace(R.id.main_content, mainTabFragment).commit()
                return true
            }
            R.id.action_chat->{
                var chatFragment = ChatFragment()
                binding.appBarlayout.visibility = View.GONE
                supportFragmentManager.beginTransaction().replace(R.id.main_content, chatFragment).commit()
                return true
            }
            R.id.action_alarm->{
                var alarmFragment = AlarmFragment()
                binding.appBarlayout.visibility = View.GONE
                supportFragmentManager.beginTransaction().replace(R.id.main_content, alarmFragment).commit()
                return true
            }
            R.id.action_mypage->{
                var myPageFragment = MyPageFragment()
                binding.appBarlayout.visibility = View.GONE
                supportFragmentManager.beginTransaction().replace(R.id.main_content, myPageFragment).commit()
                return true
            }
        }
        return false
    }
}