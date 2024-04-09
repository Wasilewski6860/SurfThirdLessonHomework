package com.example.surfthirdlessonhomework

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.surfthirdlessonhomework.launches.LaunchesFragment
import com.example.surfthirdlessonhomework.rockets.RocketsFragment
import com.example.surfthirdlessonhomework.upcoming.UpcomingFragment


class FragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragmentList: List<Fragment> = listOf<Fragment>(
        UpcomingFragment(),
        LaunchesFragment(),
        RocketsFragment()
    )
    private val titleList: List<String> = listOf( "Upcoming", "Launches", "Rockets")

    override fun getCount(): Int = titleList.size

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

}
