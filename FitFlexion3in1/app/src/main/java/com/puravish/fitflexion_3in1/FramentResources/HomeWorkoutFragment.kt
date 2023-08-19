package com.puravish.fitflexion_3in1.FramentResources

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.puravish.fitflexion_3in1.AdapterFolder.HomeWorkoutAdapter
import com.puravish.fitflexion_3in1.HomeWorkoutName
import com.puravish.fitflexion_3in1.ModelClassFolder.ControleModelsCLass
import com.puravish.fitflexion_3in1.R
import com.puravish.fitflexion_3in1.databinding.FragmentHomeworkoutBinding


class HomeWorkoutFragment : Fragment() {

    lateinit var homeBinding : FragmentHomeworkoutBinding

    lateinit var workoutList : ArrayList<ControleModelsCLass>

    lateinit var workoutAdapter: HomeWorkoutAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        homeBinding= FragmentHomeworkoutBinding.inflate(layoutInflater)


        initView()

        return homeBinding.root

    }

    private fun initView() {



//        homeBinding.rcvHome.animation.repeatCount
//        homeBinding.rcvHome.setHasFixedSize(true)
        homeBinding.rcvHome.layoutManager = LinearLayoutManager(context)

        workoutList = ArrayList()

        workoutList.add(ControleModelsCLass(R.drawable.man1,"BEGINNER BODY"))
        workoutList.add(ControleModelsCLass(R.drawable.man2,"INTIMIDATE BODY "))
        workoutList.add(ControleModelsCLass(R.drawable.man2,"ADVANCE BODY "))

        workoutAdapter = HomeWorkoutAdapter(workoutList)
        homeBinding.rcvHome.adapter = workoutAdapter


        workoutAdapter.itemclick = {

            var intent = Intent(context, HomeWorkoutName::class.java)
            startActivity(intent)

        }



    }


}