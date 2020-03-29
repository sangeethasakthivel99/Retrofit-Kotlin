package com.example.retrofit.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.model.Result
import kotlinx.android.synthetic.main.item_movie.view.*

class RecyclerViewAdapter(var list: List<Result>): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false))
    }

    override fun getItemCount(): Int {
        Log.e("adaper list",list.toString())
        Log.e("Size", list.size.toString())
        return list.size

    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item:Result) {
            itemView.movie_tv.text = item.title
            Glide.with(itemView).load("https://s3.amazonaws.com/appsdeveloperblog/Micky.jpg").into(itemView.moviePoster)
        }

    }
}