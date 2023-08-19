package com.puravish.fitflexion_3in1.AdapterFolder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.puravish.fitflexion_3in1.FramentResources.MeditaionFragment
import com.puravish.fitflexion_3in1.FramentResources.HomeWorkoutFragment
import com.puravish.fitflexion_3in1.FramentResources.YogaFragment

class TabAdapter(supportFragmentManager: FragmentManager, val tabCount: Int) : FragmentPagerAdapter(supportFragmentManager) {

    override fun getCount(): Int {
        return tabCount
    }



    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                return HomeWorkoutFragment()
            }

            1 -> {


                return MeditaionFragment()

            }

            2 -> {
                return YogaFragment()
            }

            else -> {


                return HomeWorkoutFragment()
            }


        }

    }


}