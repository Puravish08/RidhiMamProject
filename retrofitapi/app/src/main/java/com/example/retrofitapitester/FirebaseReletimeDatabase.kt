package com.example.retrofitapitester

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitapitester.databinding.ActivityFirebaseReletimeDatabaseBinding
import com.google.firebase.database.FirebaseDatabase

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FirebaseReletimeDatabase : AppCompatActivity() {

    private lateinit var binding: ActivityFirebaseReletimeDatabaseBinding
    lateinit var firebaseDatabase: FirebaseDatabase


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirebaseReletimeDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        data()
    }

    private fun data() {

        binding.dummyButton.setOnClickListener {


            initView()
        }
    }

    private fun initView() {


        val name = binding.edtName.text.toString()
        val mobile = binding.edtModile.text.toString()
        val fees = binding.edtFees.text.toString()


        firebaseDatabase = FirebaseDatabase.getInstance()

        val key = firebaseDatabase.reference.child("StudentTb").push().key ?: ""

        val data = Student(key,name,mobile,fees)
        firebaseDatabase.reference.child("StudentTb").child(key).setValue(data).addOnCompleteListener {

            if (it.isSuccessful)
            {
                Toast.makeText(this, "Sucessfully", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{

        }

        binding.edtName.text.clear()
        binding.edtModile.text.clear()
        binding.edtFees.text.clear()

    }

    data class Student(var id:String, var name:String, var mobile:String, var fees: String)

}