package com.android.assignment.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.assignment.R
import com.android.assignment.model.ResultsItem
import com.bumptech.glide.Glide


class MovieAdapter(var movieList: ArrayList<ResultsItem>, var listener: (ResultsItem) -> Unit)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(v)
    }


    fun replaceData(results: List<ResultsItem>?) {
        movieList = results as ArrayList<ResultsItem>
        notifyDataSetChanged()
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(movieList[position], listener)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return movieList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById(R.id.title) as TextView
        val thumbnail = itemView.findViewById(R.id.thumbnail) as ImageView
        val tvMoreInfo = itemView.findViewById(R.id.tvMoreInfo) as TextView

        fun bindItems(itemResult: ResultsItem, listener: (ResultsItem) -> Unit) {
            var imgPath = "http://image.tmdb.org/t/p/w185/" + itemResult.poster_path;
            Glide.with(itemView.context).load(imgPath).into(thumbnail);
            title.text = itemResult.title

            tvMoreInfo.setOnClickListener {
                listener(itemResult)
            }
        }

    }

}
