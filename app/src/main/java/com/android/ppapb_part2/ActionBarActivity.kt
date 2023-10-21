package com.android.ppapb_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.android.ppapb_part2.databinding.ActivityActionBarBinding
import com.google.android.material.tabs.TabLayoutMediator

class ActionBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActionBarBinding
    lateinit var mediator: TabLayoutMediator
    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Dashboard"

        binding = ActivityActionBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            viewPager2 = viewPager
            viewPager.adapter = TabAdapter(supportFragmentManager,this@ActionBarActivity.lifecycle)
            mediator = TabLayoutMediator(tabLayout,viewPager)
            {
                tab,position -> when(position){
                    0 -> tab.text = "setting"
                    1 -> tab.text = "message"
                    2 -> tab.text = "call"
                }
            }
            mediator.attach()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_setting-> {
                Toast.makeText(this, "Masuk Setting", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_message-> {
                Toast.makeText(this, "Masuk massage", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_call-> {
                Toast.makeText(this, "Masuk call", Toast.LENGTH_SHORT).show()
                true
            }
            else->(true)
        }
    }
}