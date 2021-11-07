package com.example.sooktoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sooktoring.databinding.ActivityRegisterDoneBinding
import com.example.sooktoring.databinding.ActivityRegisterVerifEmailBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

class RegisterDone : AppCompatActivity() {

    private var mBinding: ActivityRegisterDoneBinding? = null
    private val binding get() = mBinding!!

    var auth: FirebaseAuth? = null
    var firestore : FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        binding.btnGotoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}