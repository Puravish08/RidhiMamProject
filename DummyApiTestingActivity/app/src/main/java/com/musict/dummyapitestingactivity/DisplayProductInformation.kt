package com.musict.dummyapitestingactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.musict.dummyapitestingactivity.databinding.ActivityDisplayProductInformationBinding

class DisplayProductInformation : AppCompatActivity() {

    lateinit var disbinding:ActivityDisplayProductInformationBinding
    lateinit var  mRequestQueue: RequestQueue



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disbinding = ActivityDisplayProductInformationBinding.inflate(layoutInflater)
        setContentView(disbinding.root)

        initview()
    }

    private fun initview() {

        var id = intent.getIntExtra("id",0)
//        var title = intent.getStringExtra("title")
//        var price = intent.getIntExtra("price",0).toString()
//        var discountpercentage = intent.getIntExtra("discountpercentage",0).toString()
//        var description = intent.getStringExtra("description")
//        var stock = intent.getFloatExtra("stock",0.0f)
//        var rating = intent.getFloatExtra("rating",0.0f)


//        disbinding.title.setText(title)
//        disbinding.price.setText(price)
//        disbinding.discount.setText(discountpercentage)
//        disbinding.discription.setText(description)
//        disbinding.stock.setText(stock)
//        disbinding.rating.setText(rating)




        mRequestQueue = Volley.newRequestQueue(this)


        var req = JsonObjectRequest(
        Request.Method.GET,"https://dummyjson.com/products/$id",
        null,
        { responce ->


            var productslist = Gson().fromJson(responce.toString(),ProductsItem::class.java)



            disbinding.title.text = productslist.title
            disbinding.discription.text = productslist.description
            disbinding.price.text = productslist.price.toString()
            disbinding.discount.text = productslist.discountPercentage.toString()
            disbinding.rating.text = productslist.rating.toString()
            disbinding.stock.text = productslist.stock.toString()


            

            var ViewPagerAdapt=ViewPagerAdapt(productslist.images)
            disbinding.viewpage.adapter=ViewPagerAdapt

        },
        { error ->

            Log.e("TAG", "initview: "+error.message )
        }
        )
        mRequestQueue.add(req)
    }

}