package com.kl51.talkies.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kl51.talkies.R
import com.kl51.talkies.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        binding.movieId.text = intent.extras?.get(EXTRA_MOVIE_ID)?.toString() ?: ""
    }

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"

        fun start(activity: Context?, movieId: String) {
            val intent = Intent(activity, MovieDetailsActivity::class.java).apply {
                putExtra(EXTRA_MOVIE_ID, movieId)
            }
            activity?.startActivity(intent)
        }
    }
}
