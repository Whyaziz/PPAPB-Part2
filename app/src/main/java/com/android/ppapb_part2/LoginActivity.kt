package com.android.ppapb_part2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.android.ppapb_part2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var txtUsername: String
    private lateinit var txtEmail: String
    private lateinit var txtPhone: String
    private lateinit var txtPass: String

    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
        const val EXTRA_PASSWORD = "password"
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data

                val username = data?.getStringExtra(RegisterActivity.EXTRA_USERNAME)
                val email = data?.getStringExtra(RegisterActivity.EXTRA_EMAIL)
                val phone = data?.getStringExtra(RegisterActivity.EXTRA_PHONE)
                val password = data?.getStringExtra(RegisterActivity.EXTRA_PASSWORD)

                if (!username.isNullOrEmpty() && !email.isNullOrEmpty() && !phone.isNullOrEmpty()) {
                    txtUsername = "$username"
                    txtEmail = "$email"
                    txtPhone = "$phone"
                    txtPass = "$password"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnToRegister.setOnClickListener {

                val intentToRegister = Intent(this@LoginActivity,RegisterActivity::class.java)

                launcher.launch(intentToRegister)
            }

            btnLogin.setOnClickListener{

                val intentToHome = Intent(this@LoginActivity,HomeActivity::class.java
                )

                if (edtPass.text.toString() == txtPass && edtUsername.text.toString() == txtUsername){
                    val username = txtUsername
                    val email = txtEmail
                    val phone = txtPhone
                    val password = txtPass

                    intentToHome.putExtra(EXTRA_USERNAME, username)
                    intentToHome.putExtra(EXTRA_EMAIL, email)
                    intentToHome.putExtra(EXTRA_PHONE, phone)
                    intentToHome.putExtra(EXTRA_PASSWORD, password)

                startActivity(intentToHome)

                }
            }

        }
    }
}