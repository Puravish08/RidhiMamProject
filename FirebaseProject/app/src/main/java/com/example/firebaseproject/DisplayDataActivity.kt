package com.example.firebaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaseproject.databinding.ActivityInsertDataBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DisplayDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityInsertDataBinding
    lateinit var firebaseDatabase: FirebaseDatabase
    var studentlist = ArrayList<DisplayModelClass>()
    lateinit var adapter: DisplyDataAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }


    private fun initView() {

        firebaseDatabase = FirebaseDatabase.getInstance()


        setAdapter()

        firebaseDatabase.reference.child("StudentTb").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    studentlist.clear()
                    for (i in snapshot.children) {
                        var data = i.getValue(DisplayModelClass::class.java)
                        Log.e("TAG", "onDataChange: "+data?.phoneNum+" "+data?.name+" "+data?.fee)
                        data?.let { it1 -> studentlist.add(it1) }
                    }
//                    adapter.updateList(studentlist)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }

    private fun setAdapter() {


        //initialized yese hota hai
        adapter = DisplyDataAdapter()
        //initialized yese hota hai


//        adapter = DisplyDataAdapter({
//
//            var intent  = Intent(this,DisplayDataActivity)
//
//        })


        var manager =
            LinearLayoutManager(this@DisplayDataActivity, LinearLayoutManager.VERTICAL, false)
        binding.rcvinsert.layoutManager = manager
        binding.rcvinsert.adapter = adapter


    }
}