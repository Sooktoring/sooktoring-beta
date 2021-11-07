package com.example.sooktoring.navigation

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.sooktoring.MainActivity
import com.example.sooktoring.Message.ChatListActivity
import com.example.sooktoring.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.my_chatbox.*

class ChatFragment : Fragment(){

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_chat,container,false)
        val intent = Intent (requireActivity(), ChatListActivity::class.java)
        requireActivity()?.startActivity(intent)

        return view
    }
}