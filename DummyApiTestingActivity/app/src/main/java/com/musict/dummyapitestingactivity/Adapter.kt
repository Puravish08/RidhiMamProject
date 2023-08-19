package com.musict.dummyapitestingactivity

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide

class Adapter(var datalist: ArrayList<ProductsItem>, var context: Context, var click: (ProductsItem) -> Unit) :
    RecyclerView.Adapter<Adapter.myViewHolder>() {


    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //        var title:TextView =view.findViewById(R.id.txttitle)
        var brand: TextView = view.findViewById(R.id.txtbrand)
        var thumbnail: ImageView = view.findViewById(R.id.txtthumbnail)
        var loutprouductitem: LinearLayout = view.findViewById(R.id.linerlayourproduct)
//        var imgvp: ViewPager = view.findViewById(R.id.imgviewpager)

        var id: TextView = view.findViewById(R.id.txtid)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_items, null, false)
        val adapter = myViewHolder(view)
        return adapter


    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.id.setText(datalist[position].id.toString())
        holder.brand.setText(datalist[position].brand)

        holder.loutprouductitem.setOnClickListener {

            click.invoke(datalist[position])
        }

        var ViewPagerAdapt = ViewPagerAdapt(datalist[position].images)
//        holder.imgvp.adapter = ViewPagerAdapt


        Glide.with(context)
            .load("https://i.dummyjson.com/data/products/${datalist[position].id}/thumbnail.jpg")
            .into(holder.thumbnail)

    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}