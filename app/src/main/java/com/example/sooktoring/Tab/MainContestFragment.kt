package com.example.sooktoring.Tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sooktoring.R
import kotlinx.android.synthetic.main.main_club_fragment.*
import kotlinx.android.synthetic.main.main_contest_fragment.*

class MainContestFragment : Fragment() {
    /*override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.main_contest_fragment,container,false)
        return view
    }*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_contest_fragment, container, false)
    }
}