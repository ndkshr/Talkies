package com.kl51.talkies.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kl51.talkies.databinding.CardMovieBinding
import com.kl51.talkies.model.Movie

class MovieViewHolder(private val binding: CardMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, secureBaseUrl: String) {
        binding.movieTitle.text = movie.originalTitle
        Glide.with(binding.root.context)
                .load(secureBaseUrl + movie.posterPath)
                .into(binding.moviePoster)
    }
}
