package com.puravish.fitflexion_3in1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.puravish.fitflexion_3in1.ModelClassFolder.HomeNamesModel
import com.puravish.fitflexion_3in1.databinding.ActivityShowExciseBinding

class HomeWorkoutShowExcise : AppCompatActivity() {

    private lateinit var typeBinding: ActivityShowExciseBinding
    private lateinit var wnamelist: ArrayList<HomeNamesModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeBinding = ActivityShowExciseBinding.inflate(layoutInflater)
        setContentView(typeBinding.root)
//        initView()

//
//    private fun initView() {

//    }

        val exerciseName = intent.getStringExtra("exerciseName")
        val exerciseImageResource = intent.getIntExtra("exerciseImage",R.drawable.abs)

        val nameTextView = findViewById<TextView>(R.id.nameTextView1)
        nameTextView.text = exerciseName

        val imageView = findViewById<ImageView>(R.id.exerciseImage1)
        imageView.setImageResource(exerciseImageResource)
    }

}