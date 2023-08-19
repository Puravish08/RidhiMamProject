package com.puravish.fitflexion_3in1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import  com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import com.puravish.fitflexion_3in1.AdapterFolder.TabAdapter

class MainActivity : AppCompatActivity() {


    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // aa code this screen no phono n pade

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        // this code is new learning


        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Home\nWorkout"))
        tabLayout.addTab(tabLayout.newTab().setText("Meditation\nTime"))
        tabLayout.addTab(tabLayout.newTab().setText("Yoga\nDay"))
//        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(supportFragmentManager,tabLayout.tabCount)
        viewPager.adapter=adapter


        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))




       tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {




           override fun onTabSelected(tab: TabLayout.Tab?) {

              viewPager.setCurrentItem(tab!!.position)

           }

           override fun onTabUnselected(tab: TabLayout.Tab?) {

           }

           override fun onTabReselected(tab: TabLayout.Tab?) {

           }


       })


}
}