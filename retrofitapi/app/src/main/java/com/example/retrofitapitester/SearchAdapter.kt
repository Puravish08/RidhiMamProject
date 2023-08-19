package com.example.retrofitapitester

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.musict.dummyapitestingactivity.ProductsItem


class SearchAdapter(var context: Context,var searchlist: List<ProductsItem>) : RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {
    class MyViewHolder(itemview : View):RecyclerView.ViewHolder(itemview) {
        var txtsearchid: TextView = itemview.findViewById(R.id.txtsearchid)
        var txtsearchcategory: TextView = itemview.findViewById(R.id.txtsearchcategory)
        var imgsearchthumbnail: ImageView = itemview.findViewById(R.id.imgsearchthumbnail)
        var loutsearchitem : LinearLayout = itemview.findViewById(R.id.loutsearchitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.searchproductitemfile,parent,false)
        var myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return searchlist!!.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtsearchid.setText(searchlist!!.get(position)?.id.toString())
        holder.txtsearchcategory.setText(searchlist!![position].category)
//        holder.imgsearchthumbnail.setImageResource(searchlist[position].thumbnail)
        Glide.with(context)
            .load("https://dummyjson.com/products/search?q/${searchlist!![position].id}/thumbnail.jpg")
            .into(holder.imgsearchthumbnail)
    }
}