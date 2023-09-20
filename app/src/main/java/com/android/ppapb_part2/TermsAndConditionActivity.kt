package com.android.ppapb_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.ppapb_part2.RegisterActivity.Companion.EXTRA_JUDUL
import com.android.ppapb_part2.databinding.ActivityTermsAndConditionBinding

class TermsAndConditionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTermsAndConditionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsAndConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val txtJudul = intent.getStringExtra(EXTRA_JUDUL)
        binding.judul.text =txtJudul
    }
}