package com.musict.dummyapitestingactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapitester.ApiInterface
import com.example.retrofitapitester.Apiclient

import com.example.retrofitapitester.databinding.ActivityDisplayProductInformationBinding
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayProductInformation : AppCompatActivity() {

    lateinit var disbinding:ActivityDisplayProductInformationBinding
    var apiInterface: ApiInterface? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disbinding = ActivityDisplayProductInformationBinding.inflate(layoutInflater)
        setContentView(disbinding.root)

        initview()
    }

    private fun initview() {

        var id = intent.getIntExtra("id",0)

        apiInterface = Apiclient.getClient()?.create(ApiInterface::class.java)
        apiInterface?.getdetails(id)?.enqueue(object : Callback<ProductsItem> {
            override fun onResponse(call: Call<ProductsItem>, response: Response<ProductsItem>) {
                var images = response.body()?.images
                var title = response.body()?.title
                var price = response.body()?.price
                var discountPercentage = response.body()?.discountPercentage
                var description = response.body()?.description
                var stock = response.body()?.stock
                var rating = response.body()?.rating

                var ViewPagerAdapter = images?.let { ViewPagerAdapt(it) }

               disbinding.viewpage.adapter=ViewPagerAdapter
               disbinding.title.text=title
               disbinding.price.text=price.toString()
               disbinding.discount.text=discountPercentage.toString()
               disbinding.discription.text=description
               disbinding.stock.text=stock.toString()
               disbinding.rating.text=rating.toString()
            }



            override fun onFailure(call: Call<ProductsItem>, t: Throwable) {

            }


        })
    }
}