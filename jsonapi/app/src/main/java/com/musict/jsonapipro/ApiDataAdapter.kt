package com.musict.jsonapipro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApiDataAdapter(var list : ArrayList<PostResponseItemItem>) :
    RecyclerView.Adapter<ApiDataAdapter.myViewHolder>() {



    class myViewHolder(view : View) :RecyclerView.ViewHolder(view){

        var id : TextView = view.findViewById(R.id.txtid)
        var userId : TextView = view.findViewById(R.id.txtuserid)
        var title : TextView = view.findViewById(R.id.txttitleid)
        var body : TextView = view.findViewById(R.id.txtbodyid)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
var v=LayoutInflater.from(parent.context).inflate(R.layout.api_list,parent,false)
        var view = myViewHolder(v)
        return view
    }

    override fun getItemCount(): Int {


        return list.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.id.text=list[position].id.toString()
        holder.userId.text=list[position].userId.toString()
        holder.title.text=list[position].title.toString()
        holder.body.text=list[position].body.toString()



    }
}