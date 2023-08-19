package com.example.firebaseproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DisplyDataAdapter : RecyclerView.Adapter<DisplyDataAdapter.myViewHolder>() {


    var list =  ArrayList<DisplayModelClass>()

    class myViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {


        var name = itemview.findViewById<TextView>(R.id.txtName)
        var mobile = itemview.findViewById<TextView>(R.id.txtMobile)
        var fees = itemview.findViewById<TextView>(R.id.txtFees)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.display_item,parent,false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.name.setText(list[position].name)
        holder.mobile.setText(list[position].phoneNum)
        holder.fees.setText(list[position].fee)
    }


}
