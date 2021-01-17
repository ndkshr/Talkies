package com.kl51.talkies.view

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kl51.talkies.R
import com.kl51.talkies.databinding.ActivityMovieDetailsBinding
import com.kl51.talkies.model.MovieDetailObject
import com.kl51.talkies.utils.GlideApp
import com.kl51.talkies.utils.PreferenceUtils
import com.kl51.talkies.utils.ViewModelFactory
import com.kl51.talkies.viewmodel.MovieDetailViewModel
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieDetailsBinding
    lateinit var movieId: String

    @Inject
    lateinit var preferenceUtils: PreferenceUtils

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var compositeDisposable: CompositeDisposable

    private val viewModel: MovieDetailViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MovieDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)

        movieId = intent.extras?.get(EXTRA_MOVIE_ID)?.toString() ?: ""

        compositeDisposable = CompositeDisposable()

        viewModel.getMovieDetails(movieId)
            .doOnSubscribe { compositeDisposable.add(it) }
            .doOnSuccess { renderMovieDetailScreen(it) }
            .doOnError { showErrorToast() }
            .subscribe()
    }

    private fun renderMovieDetailScreen(movieObject: MovieDetailObject) {
        binding.movieTitle.text = movieObject.originalTitle
        binding.movieDescription.text = movieObject.overview

        initAnimations()

        GlideApp.with(this)
            .load(preferenceUtils.getSecuredBaseUrl() + POSTER_SIZE + movieObject.posterPath)
            .into(binding.moviePoster)
    }

    private fun initAnimations() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.rise_up)
        animation.reset()

        binding.movieTitle.clearAnimation()
        binding.movieDescription.clearAnimation()

        binding.movieTitle.startAnimation(animation)
        binding.movieDescription.startAnimation(animation)
    }

    private fun showErrorToast() {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
        private const val POSTER_SIZE = "w500"

        fun start(activity: Context?, movieId: String) {
            val intent = Intent(activity, MovieDetailsActivity::class.java).apply {
                putExtra(EXTRA_MOVIE_ID, movieId)
            }
            activity?.startActivity(intent)
        }
    }
}
