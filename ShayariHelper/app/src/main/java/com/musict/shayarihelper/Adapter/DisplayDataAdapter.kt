package com.musict.shayarihelper.Adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.helper.widget.MotionEffect
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.musict.shayarihelper.DisplayCategoryModelData
import com.musict.shayarihelper.R
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class DisplayDataAdapter(
    var context: Context,
    private var dataclick: (DisplayCategoryModelData) -> Unit,
    private var like: (Int, Int) -> Unit
) : RecyclerView.Adapter<DisplayDataAdapter.MyViewHolder>() {


//    val adapter = DisplayDataAdapter(context, dataList)

    private var sharList = ArrayList<DisplayCategoryModelData>()

 class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ShayariItem: TextView = itemView.findViewById(R.id.txtshayari)
        var imglike: ImageView = itemView.findViewById(R.id.heartlike)
        var share: ImageView = itemView.findViewById(R.id.share)
        var imgcopy: ImageView = itemView.findViewById(R.id.copydc)
        var layout: LinearLayout = itemView.findViewById(R.id.layout)


//        var linear : LinearLayout=itemView.findViewById(R.id.linear-dis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_category_data, parent, false)
        return MyViewHolder(v)

  }

    override fun getItemCount(): Int {
        return sharList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.ShayariItem.text = sharList[position].shyari_item

        holder.ShayariItem.setOnClickListener {

            dataclick.invoke(sharList[position])
        }


        holder.imgcopy.setOnClickListener {

            val clipboardManager = holder.itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text", holder.ShayariItem.text)
                clipboardManager.setPrimaryClip(clipData)

            MotionToast.darkColorToast(
                context as Activity, "Copy Success!", " Quotes Copy Successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context, www.sanju.motiontoast.R.font.helvetica_regular)
            )

        }

        holder.share.setOnClickListener {


            val p = Intent(Intent.ACTION_SEND)
            p.type = "text/plan"
            p.putExtra(Intent.EXTRA_TEXT, sharList[position].shyari_item)
            context.startActivity(p)
//            p.putExtra(Intent.EXTRA_TEXT, " " + shayari)
//            startActivity(Intent.createChooser(p, "Share"))
        }


        holder.layout.setOnClickListener {

            dataclick.invoke(sharList[position])


        }
        if (sharList[position].status == 1) {

            holder.imglike.setImageResource(R.drawable.redlike)

        } else {
            holder.imglike.setImageResource(R.drawable.whiteborderlike)

        }



        holder.imglike.setOnClickListener {

            if (sharList[position].status == 1) {

                like.invoke(sharList[position].shyari_id, 0)
                holder.imglike.setImageResource(R.drawable.whiteborderlike)
                sharList[position].status = 0
            } else {
                like.invoke(sharList[position].shyari_id, 1)
                holder.imglike.setImageResource(R.drawable.redlike)
                sharList[position].status = 1
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatelist(sharList: ArrayList<DisplayCategoryModelData>) {
        this.sharList = ArrayList()
        this.sharList.addAll(sharList)
        notifyDataSetChanged()
    }

}