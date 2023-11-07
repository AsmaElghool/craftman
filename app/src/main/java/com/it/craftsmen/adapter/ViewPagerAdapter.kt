package com.it.craftsmen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(container: FragmentManager, private val fragmentList: List<Fragment>, lifecycle: Lifecycle):FragmentStateAdapter(container, lifecycle) {

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) =  fragmentList[position]

}