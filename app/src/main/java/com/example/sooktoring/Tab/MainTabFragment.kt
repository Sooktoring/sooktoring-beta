package com.example.sooktoring.Tab

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.sooktoring.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.firestore.core.ActivityScope
import kotlinx.android.synthetic.main.main_tab_fragment.*

class MainTabFragment : Fragment() {

    var fragmentView : View? = null
    var mVaActionBar : ValueAnimator? = null
    var viwId : Int? = null
    var toolbarId : Int? = null


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        fragmentView = LayoutInflater.from(activity).inflate(R.layout.main_tab_fragment,container,false)

        return fragmentView
    }

    inner class PagerAdapter (supportFragment: FragmentManager) : FragmentStatePagerAdapter(supportFragment) {
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
                    MainTabFragment()
            }
        }

    }


}