package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.model.PopularNetModel
import com.example.movieapp.model.ResultNetModel
import com.example.movieapp.service.ApiURL

class MovieTopRateAdapter(private var resultNetModel: ArrayList<ResultNetModel>) : RecyclerView.Adapter<MovieTopRateAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieTopRateAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_top_rate, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieTopRateAdapter.ViewHolder, position: Int) {

        val getResultNetModel = resultNetModel[position]
        holder.textViewMovie.text = getResultNetModel.originalTitle

        var uri : String = ApiURL.IMAGE_URL + getResultNetModel.backdropPath.toString()
        Glide.with(holder.itemView.context).load(uri).into(holder.imageViewMovie)


    }

    override fun getItemCount(): Int {

        return resultNetModel.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val imageViewMovie: ImageView
        val textViewMovie: TextView



        init {
            imageViewMovie =mView.findViewById(R.id.imageViewMovie)
            textViewMovie =mView.findViewById(R.id.nameMovie)


        }
    }
}