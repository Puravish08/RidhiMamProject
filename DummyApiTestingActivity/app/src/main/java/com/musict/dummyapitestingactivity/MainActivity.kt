package com.musict.dummyapitestingactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.musict.dummyapitestingactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


lateinit var binding : ActivityMainBinding

    lateinit var mRequistQueue: RequestQueue
     lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()


    }

    private fun initView() {


        mRequistQueue = Volley.newRequestQueue(this)




        var req = JsonObjectRequest(
            Request.Method.GET,
            "https://dummyjson.com/products",
            null,
            { responese ->

//
              var  datalist = Gson().fromJson(responese.toString(),ProductResponce::class.java)
                var adapter = Adapter(datalist.products,this )

                {

                    var intent = Intent(this,DisplayProductInformation::class.java)
                        intent.putExtra("id",it.id)
                        intent.putExtra("title",it.title)
                        intent.putExtra("price",it.price)
                        intent.putExtra("descountpercenteage",it.discountPercentage)
                        intent.putExtra("description",it.description)
                        intent.putExtra("stock",it.stock)
                        intent.putExtra("rating",it.rating)

                    startActivity(intent)

                }

                  var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.rcv.layoutManager = manager
                binding.rcv.adapter = adapter


            },



            { error ->
                Log.e("TAG", "initview: "+error.message)

            }
        )
        mRequistQueue.add(req)
    }
}



