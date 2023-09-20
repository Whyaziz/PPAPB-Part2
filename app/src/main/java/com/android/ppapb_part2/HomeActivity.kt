package com.android.ppapb_part2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.android.ppapb_part2.RegisterActivity.Companion.EXTRA_USERNAME
import com.android.ppapb_part2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(RegisterActivity.EXTRA_EMAIL)
        val phone = intent.getStringExtra(RegisterActivity.EXTRA_PHONE)

        with(binding){

            binding.txtUsername.text = "$username"
            binding.txtEmail.text = "$email"
            binding.txtPhone.text = "$phone"

            btnLogout.setOnClickListener{
                finish()
            }

        }
    }
}