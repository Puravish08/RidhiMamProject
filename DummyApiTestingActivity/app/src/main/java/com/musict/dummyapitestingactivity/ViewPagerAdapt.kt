package com.musict.dummyapitestingactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import java.util.Objects

class ViewPagerAdapt(val datlist: List<String?>) : PagerAdapter() {
    override fun getCount(): Int {

        return datlist.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ImageView
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemView:View=LayoutInflater.from(container.context).inflate(R.layout.view_page_item,container,false)
        val imageView:ImageView=itemView.findViewById(R.id.imgviewpager)



        Glide.with(container.context).load("${datlist[position]}").into(imageView)

        Objects.requireNonNull(container).addView(itemView)


        return itemView

    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as ImageView)
    }


}