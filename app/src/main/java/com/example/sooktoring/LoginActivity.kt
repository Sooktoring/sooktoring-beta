package com.example.sooktoring

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sooktoring.Message.ChatListActivity
import com.example.sooktoring.databinding.ActivityLoginBinding
import com.example.sooktoring.databinding.ActivityRegisterBinding
import com.example.sooktoring.databinding.ActivityRegisterVerifEmailBinding


import com.google.android.gms.auth.api.signin.GoogleSignInAccount

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private var mBinding: ActivityLoginBinding? = null
    private val binding get() = mBinding!!
    

    var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.emailLoginButton.setOnClickListener {
            signinEmail()
            
        }

        binding.signupButton.setOnClickListener {
            moveRegisterPage()
        }
    }

    private fun moveRegisterPage() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
    
    @SuppressLint("RestrictedApi")
    fun signinAndSignup() {
        auth?.createUserWithEmailAndPassword(
            binding.emailEdittext.text.toString(),
            binding.passwordEdittext.text.toString()
        )
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Creating a user account

                    val uid = FirebaseAuth.getInstance().uid ?:""
                    val db = FirebaseFirestore.getInstance().collection("users")
                    val userid = et_name.text.toString()
                    val user = auth!!.currentUser

                    db.document(uid)
                        .set(user!!)
                    FirebaseAuth.getInstance().currentUser?.reload()?.addOnSuccessListener { void ->
                        var user = FirebaseAuth.getInstance().currentUser
                        if (user?.isEmailVerified == true) {
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                    }

                } else if (task.exception?.message.isNullOrEmpty()) {
                    // Show the error message
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                } else {
                    // Login if you have account
                    signinEmail()
                }
            }
    }

    fun signinEmail() {
        auth?.signInWithEmailAndPassword(
            binding.emailEdittext.text.toString(),
            binding.passwordEdittext.text.toString()
        )
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //Login
                        // Creating a user account
                        val user = auth!!.currentUser
                        FirebaseAuth.getInstance().currentUser?.reload()
                            ?.addOnSuccessListener { void ->
                                var user = FirebaseAuth.getInstance().currentUser
                                if (user?.isEmailVerified == true) {
                                    startActivity(Intent(this, MainActivity::class.java))
                                }
                            }

                }else {
                    //Show the error message
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        fun moveMainPage(user: FirebaseUser?) {
            if (user != null) {
                startActivity(Intent(this, ChatListActivity::class.java))
            }
        }

    }
}