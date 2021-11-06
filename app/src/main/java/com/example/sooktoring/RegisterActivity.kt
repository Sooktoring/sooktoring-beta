package com.example.sooktoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.sooktoring.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {

    private var mBinding: ActivityRegisterBinding? = null
    private val binding get() = mBinding!!

    var auth: FirebaseAuth? = null

    private val email_check_flag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.tvPasswordErrorMsg.visibility = View.GONE

        binding.btnJoin.setOnClickListener {
            registerEvent()
        }

    }

    fun registerEvent() {

        var UserName = binding.etName.text.toString()
        var UserEmail = binding.etMail.text.toString()
        var UserPassword = binding.etPassword.text.toString()
        var UserPassword_check = binding.etPasswordCheck.text.toString()

        // EditText 공백 체크
        if (UserName.equals("")) {
            binding.etName.setBackgroundResource(R.drawable.edittext_background_error)
        } else {
            binding.etName.setBackgroundResource(R.drawable.edittext_background)
        }

        if (UserEmail.equals("")) {
            binding.etMail.setBackgroundResource(R.drawable.edittext_background_error)
        } else {
            binding.etMail.setBackgroundResource(R.drawable.edittext_background)
        }

        if (UserPassword.equals("")) {
            binding.etPassword.setBackgroundResource(R.drawable.edittext_background_error)
        } else {
            binding.etPassword.setBackgroundResource(R.drawable.edittext_background)
        }

        if (UserPassword_check.equals("") || UserPassword_check.equals(UserPassword) == false) {
            binding.etPasswordCheck.setBackgroundResource(R.drawable.edittext_background_error)

            if(UserPassword_check.equals(UserPassword) == false) {
                binding.tvPasswordErrorMsg.visibility = View.VISIBLE
            } else {
                binding.tvPasswordErrorMsg.visibility = View.GONE
            }
        } else {
            binding.etPasswordCheck.setBackgroundResource(R.drawable.edittext_background)

            if(UserPassword.equals(UserPassword_check)) {
                binding.tvPasswordErrorMsg.visibility = View.GONE
            }
        }


        if (UserName.equals("") != null && UserEmail.equals("") != null && UserPassword.equals("") != null && UserPassword_check.equals("") != null) {
            auth?.createUserWithEmailAndPassword(UserEmail,
                binding.etPassword.text.toString())?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful) {
                    // Creating a user account
                    moveRegisterNextPage(task.result?.user)
                } else if(task.exception?.message.isNullOrEmpty()){
                    // Show the error message
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                } else {
                    // Login if you have account
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun moveRegisterNextPage(user: FirebaseUser?){
        if(user != null) {
            startActivity(Intent(this, Register_verif_email::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}