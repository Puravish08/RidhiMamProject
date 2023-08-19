package com.puravish.fitflexion_3in1.AdapterFolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puravish.fitflexion_3in1.ModelClassFolder.ControleModelsCLass
import com.puravish.fitflexion_3in1.R

class HomeWorkoutAdapter(
   private var hworklist: ArrayList<ControleModelsCLass>

    ) : RecyclerView.Adapter<HomeWorkoutAdapter.myViewHolder>() {


    var itemclick : ((ControleModelsCLass) -> Unit)? = null



    class myViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {


var txtwork : TextView = itemview.findViewById(R.id.txtwork)
var imgpose : ImageView = itemview.findViewById(R.id.imgpose)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val v= LayoutInflater.from(parent.context).inflate(R.layout.home_workout_item_file,parent,false)
return myViewHolder(v)
    }

    override fun getItemCount(): Int {

        return hworklist.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val workout = hworklist[position]


        holder.imgpose.setImageResource(workout.HomeImage)

        holder.txtwork.text = workout.textwork

        holder.itemView.setOnClickListener{

            itemclick!!.invoke(workout)

        }





    }


}