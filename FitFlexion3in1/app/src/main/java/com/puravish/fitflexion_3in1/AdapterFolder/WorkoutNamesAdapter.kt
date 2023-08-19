package com.puravish.fitflexion_3in1.AdapterFolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puravish.fitflexion_3in1.ModelClassFolder.HomeNamesModel
import com.puravish.fitflexion_3in1.R

class WorkoutNamesAdapter(  private val wnamelist: List<HomeNamesModel>,
                            private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<WorkoutNamesAdapter.myViewHolder>() {



   inner class myViewHolder (itemview:View) : RecyclerView.ViewHolder(itemview){

       val exerciseName: TextView = itemView.findViewById(R.id.exciseNames)
       val exerciseImage: ImageView = itemView.findViewById(R.id.imgPhoto)

       init {
           itemView.setOnClickListener {
               onItemClick(adapterPosition)
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.h_w_item_file, parent, false)
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  wnamelist.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentExercise = wnamelist[position]
        holder.exerciseName.text = currentExercise.name
        holder.exerciseImage.setImageResource(currentExercise.imageResource)

    }

}

