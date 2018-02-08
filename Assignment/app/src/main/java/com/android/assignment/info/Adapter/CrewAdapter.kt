package com.android.assignment.info.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.assignment.R
import com.android.assignment.model.CrewItem
import com.bumptech.glide.Glide


class CrewAdapter(private var crewItemList: List<CrewItem>?)
    : RecyclerView.Adapter<CrewAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(v)
    }




    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(crewItemList!![position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return crewItemList?.size!!
    }

    //the class is holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById(R.id.title) as TextView
        val thumbnail = itemView.findViewById(R.id.tvThumbnail) as ImageView
        val tvMoreInfo = itemView.findViewById(R.id.tvMoreInfo) as TextView

        fun bindItems(itemCrew: CrewItem) {
            val imgPath = """http://image.tmdb.org/t/p/w185/${itemCrew.profile_path}"""
            Glide.with(itemView.context).load(imgPath).into(thumbnail)
            title.text = itemCrew.name
            tvMoreInfo.visibility=View.GONE
        }

    }

}
