package com.example.firebaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firebaseproject.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        data()
    }

    private fun data() {

        binding.dummyButton.setOnClickListener {


            initView()
        }


        binding.display.setOnClickListener {

            var  i = Intent(this,DisplayDataActivity::class.java)
            Log.e("TAG", "data: " +i )
            startActivity(i)

        }
    }

    private fun initView() {

        val name = binding.edtName.text.toString()
        val mobile = binding.edtModile.text.toString()
        val fees = binding.edtFees.text.toString()


        firebaseDatabase = FirebaseDatabase.getInstance()



        val key = firebaseDatabase.reference.child("StudentTb").push().key ?: ""
        val data = DisplayModelClass(
           key,
            binding.edtName.text.toString(),
            binding.edtModile.text.toString(),
            binding.edtFees.text.toString(),

        )
        firebaseDatabase.reference.child("StudentTb").child(key).setValue(data).addOnCompleteListener {

            if (it.isSuccessful)
            {
//                Toast.makeText(this, "Sucessfully", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{

        }
        binding.edtName.text.clear()
        binding.edtModile.text.clear()
        binding.edtFees.text.clear()

    }

    data class Student(var id:String, var name:String, var mobile:String, var fees: String)

}

