package com.kl51.talkies.view

import androidx.recyclerview.widget.RecyclerView
import com.kl51.talkies.R
import com.kl51.talkies.databinding.CardMovieBinding
import com.kl51.talkies.model.Movie
import com.kl51.talkies.utils.GlideApp

class MovieViewHolder(
    private val binding: CardMovieBinding,
    private val onCardClicked: (String, String) -> (Unit)
) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val IMAGE_MEDIUM = "w185"
    }

    fun bind(movie: Movie, secureBaseUrl: String) {
        binding.movieTitle.text = movie.originalTitle

        val imageUrl = secureBaseUrl + IMAGE_MEDIUM + movie.posterPath
        GlideApp.with(binding.root.context)
            .load(imageUrl)
            .placeholder(R.mipmap.ic_placeholder)
            .into(binding.moviePoster)

        binding.root.setOnClickListener {
            onCardClicked.invoke(movie.title, movie.overview)
        }
    }
}
