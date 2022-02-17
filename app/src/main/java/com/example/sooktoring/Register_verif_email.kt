package com.example.sooktoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sooktoring.databinding.ActivityRegisterBinding
import com.example.sooktoring.databinding.ActivityRegisterVerifEmailBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Register_verif_email : AppCompatActivity() {

    private var mBinding: ActivityRegisterVerifEmailBinding? = null
    private val binding get() = mBinding!!

    var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterVerifEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        // 인증 이메일 전송
        if(FirebaseAuth.getInstance().currentUser!!.isEmailVerified){
            Toast.makeText(this, "이메일 인증이 이미 완료되었습니다", Toast.LENGTH_LONG).show()
            return
        }

        FirebaseAuth.getInstance().currentUser!!.sendEmailVerification().addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "인증 메일을 보냈습니다", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_LONG).show()
            }
        }

        binding.btnEmailJoin.setOnClickListener {
            checkAndGoToNextStep()
        }

    }

    fun checkAndGoToNextStep() {
        val user = auth!!.currentUser
        FirebaseAuth.getInstance().currentUser?.reload()
            ?.addOnSuccessListener { void ->
                var user = FirebaseAuth.getInstance().currentUser
                if (user?.isEmailVerified == true) {
                    startActivity(Intent(this, RegisterDone::class.java))
                } else {
                    Toast.makeText(this, "이메일 인증을 진행해주세요.", Toast.LENGTH_LONG).show()
                }
            }

        }

    fun moveLoginPage(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

}