package com.kl51.talkies.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kl51.talkies.databinding.CardMovieBinding
import com.kl51.talkies.model.Movie

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {

    private var moviesList =  ArrayList<Movie>()
    lateinit var secureBaseUrl: String

    fun setData(list: List<Movie>, baseUrl: String) {
        moviesList.addAll(list)
        secureBaseUrl = baseUrl
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            CardMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList[position], secureBaseUrl)
    }

}