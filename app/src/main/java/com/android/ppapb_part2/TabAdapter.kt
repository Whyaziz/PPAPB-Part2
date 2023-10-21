package com.android.ppapb_part2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fm:FragmentManager, lifecycle:Lifecycle): FragmentStateAdapter(fm,lifecycle) {

    val page = arrayOf(SettingFragment(),CallFragment(),MessageFragment())

    override fun getItemCount(): Int {
        return page.size
    }

    override fun createFragment(position: Int): Fragment {
        return page[position]
    }
}