package com.android.ppapb_part2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.ppapb_part2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
        const val EXTRA_PASSWORD = "password"
        const val EXTRA_JUDUL = "judul"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnRegister.setOnClickListener{

                val intentToLogin = Intent(this@RegisterActivity,LoginActivity::class.java)

                val username = edtUsername.text.toString()
                val email = edtEmail.text.toString()
                val phone = edtPhone.text.toString()
                val password = edtPass.text.toString()

                intentToLogin.putExtra(EXTRA_USERNAME, username)
                intentToLogin.putExtra(EXTRA_EMAIL, email)
                intentToLogin.putExtra(EXTRA_PHONE, phone)
                intentToLogin.putExtra(EXTRA_PASSWORD, password)

                setResult(Activity.RESULT_OK, intentToLogin)
                finish()
            }

            btnToTerms.setOnClickListener {
                val intentToTerms = Intent(this@RegisterActivity,TermsAndConditionActivity::class.java)

                intentToTerms.putExtra(EXTRA_JUDUL,"Terms And Service")
                startActivity(intentToTerms)
            }

            btnToCondition.setOnClickListener {
                val intentToTerms = Intent(this@RegisterActivity,TermsAndConditionActivity::class.java)

                intentToTerms.putExtra(EXTRA_JUDUL,"Condition")
                startActivity(intentToTerms)
            }
        }
    }
}