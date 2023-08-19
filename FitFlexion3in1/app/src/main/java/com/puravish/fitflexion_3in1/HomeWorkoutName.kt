package com.puravish.fitflexion_3in1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.puravish.fitflexion_3in1.AdapterFolder.WorkoutNamesAdapter
import com.puravish.fitflexion_3in1.ModelClassFolder.HomeNamesModel
import com.puravish.fitflexion_3in1.databinding.ActivityHomeWorkoutNameBinding

class HomeWorkoutName : AppCompatActivity() {

    lateinit var  typeBinding : ActivityHomeWorkoutNameBinding
    lateinit var wnamelist : ArrayList<HomeNamesModel>
    lateinit var newArray: IntArray

    lateinit var wnameAdapter: WorkoutNamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeBinding = ActivityHomeWorkoutNameBinding.inflate(layoutInflater)
        setContentView(typeBinding.root)

        initView()
    }

    private fun initView() {


        typeBinding.rcvNames.setHasFixedSize(true)
        typeBinding.rcvNames.layoutManager = LinearLayoutManager(applicationContext)

        wnamelist = ArrayList()

        wnamelist.add(HomeNamesModel("ARM", R.drawable.man1))
        wnamelist.add(HomeNamesModel("CHEST", R.drawable.man2))
        wnamelist.add(HomeNamesModel("ABS", R.drawable.man2))
        wnamelist.add(HomeNamesModel("LEG", R.drawable.man2))
        wnamelist.add(HomeNamesModel("SHOULDER & BACK", R.drawable.man2))

        val wnameAdapter = WorkoutNamesAdapter(wnamelist) { position ->
            val intent = Intent(this, HomeWorkoutShowExcise::class.java)
            val exercise = wnamelist[position]
            intent.putExtra("exerciseName", exercise.name)
            intent.putExtra("exerciseImage", exercise.imageResource)
            startActivity(intent)
        }

        typeBinding.rcvNames.adapter = wnameAdapter

    }





    }
