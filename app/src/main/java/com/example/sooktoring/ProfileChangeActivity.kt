package com.example.sooktoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sooktoring.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileChangeActivity : AppCompatActivity() {

    private var mBinding: ActivityRegisterBinding? = null
    private val binding get() = mBinding!!

    var auth: FirebaseAuth? = null
    var firestore : FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()



    }
}