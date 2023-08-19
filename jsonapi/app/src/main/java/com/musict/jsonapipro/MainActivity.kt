package com.musict.jsonapipro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.MessageQueue
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.musict.jsonapipro.databinding.ActivityMainBinding
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var mRequistQueue: RequestQueue
    lateinit var adapter : ApiDataAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {



        mRequistQueue = Volley.newRequestQueue(this)



        var req = JsonArrayRequest(Request.Method.GET,
        "https://jsonplaceholder.typicode.com/posts",
            null,
            { responese ->



                val datalist : ArrayList<PostResponseItemItem>
                val listtype : Type? = object : TypeToken<List<PostResponseItemItem?>?>() {}.type

                datalist = Gson().fromJson(responese.toString(),listtype)
//                for(i in 0 until datalist.size)
//                {
//
////                    Log.e("TAG", "initview: "+datalist.get(i).id )
////                    Log.e("TAG", "initview: "+datalist.get(i).userId)
////                    Log.e("TAG", "initview: "+datalist.get(i).title)
////                    Log.e("TAG", "initview: "+datalist.get(i).body + "\n\n" )
//
//
//                }


                adapter = ApiDataAdapter(datalist)
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