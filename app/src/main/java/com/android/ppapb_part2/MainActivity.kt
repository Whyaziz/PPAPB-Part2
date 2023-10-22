package com.android.ppapb_part2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.android.ppapb_part2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mediator: TabLayoutMediator
    lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            viewPager2 = viewPager
            viewPager.adapter = TabAdapter(supportFragmentManager,this@MainActivity.lifecycle)
            mediator = TabLayoutMediator(tabLayout,viewPager)
            {
                    tab,position -> when(position){
                0 -> tab.text = "Login"
                1 -> tab.text = "Register"
            }
            }
            mediator.attach()

        }
    }
}