package com.musict.dummyapitestingactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapitester.ApiInterface
import com.example.retrofitapitester.Apiclient
import com.example.retrofitapitester.LoginActivityy
import com.example.retrofitapitester.SearchAdapter
import com.example.retrofitapitester.databinding.ActivityMainBinding
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


lateinit var binding : ActivityMainBinding

    var apiInterface: ApiInterface? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
      search()

    }

    @SuppressLint("SuspiciousIndentation")
    private fun initView() {



        binding.btnlogout.setOnClickListener {



            val sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            val myEdit : SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()

            var intent = Intent(this, LoginActivityy::class.java)
            startActivity(intent)
            finish()


        }

//
//        binding.imgs.setOnClickListener {
//            var search = Intent(this, SearchingActivity::class.java)
//            startActivity(search)
//        }

        apiInterface = Apiclient.getClient()?.create(ApiInterface::class.java)


        apiInterface?.getAllProduct()?.enqueue(object : Callback<ProductResponce<Any?>> {
            override fun onResponse(
                call: Call<ProductResponce<Any?>>,
                response: Response<ProductResponce<Any?>>
            ) {
                var mainlist = response.body()?.products
//                for(i in 0 until mainlist?.size!!)
//                {
//                    Log.e("TAG", "onResponse: "+mainlist[i]?.title )
//                }

                var adapter = mainlist?.let {
                    Adapter(it, this@MainActivity) { product ->
                        var intent =
                            Intent(this@MainActivity, DisplayProductInformation::class.java)
                        intent.putExtra("id", product.id)
                        startActivity(intent)
                    }
                }
                var manager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                binding.rcv.layoutManager = manager
                binding.rcv.adapter = adapter
            }


            override fun onFailure(call: Call<ProductResponce<Any?>>, t: Throwable) {

            }

        })

    }

        private fun search() {
            binding.btns.setOnClickListener {
                var searchText = binding.sedt.text.toString()
                Log.e("TAG", "search: "+searchText )
                apiInterface?.getSearchProduct(searchText)?.enqueue(object : Callback<ProductResponce<ProductsItem>>{
                    override fun onResponse(
                        call: Call<ProductResponce<ProductsItem>>,
                        response: Response<ProductResponce<ProductsItem>>
                    ) {
                        Log.e("TAG", "onResponse: " +response)
                        var searchlist = response.body()?.products
                        var adapter = SearchAdapter(this@MainActivity, searchlist!!)
                        var manager = LinearLayoutManager(this@MainActivity)
                        binding.rcv.layoutManager = manager
                        binding.rcv.adapter=adapter


                    }

                    override fun onFailure(call: Call<ProductResponce<ProductsItem>>, t: Throwable) {

                    }


                })


            }


        }


    override fun onBackPressed() {

    }




    }

