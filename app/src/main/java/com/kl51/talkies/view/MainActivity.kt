package com.kl51.talkies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kl51.talkies.R
import com.kl51.talkies.databinding.ActivityMainBinding
import com.kl51.talkies.model.Movie
import com.kl51.talkies.utils.ViewModelFactory
import com.kl51.talkies.viewmodel.MainActivityViewModel
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
    }

    private lateinit var secureBaseUrl: String

    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        compositeDisposable = CompositeDisposable()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initRecyclerView()

        getConfigurationsFromRemote()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    private fun initRecyclerView() {
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
        binding.rvMovie.layoutManager = GridLayoutManager(this, 2)
    }

    private fun getMoviesFromRemote() {
        viewModel.getUpcomingMovies()
                .doOnSubscribe { compositeDisposable.add(it) }
                .doOnSuccess { showUpcomingMovies(it.results) }
                .doOnError { showError() }
                .subscribe()
    }

    private fun getConfigurationsFromRemote() {
        viewModel.getConfiguration()
                .doOnSubscribe{ compositeDisposable.add(it) }
                .doOnSuccess {
                    secureBaseUrl = it.images.secureBaseUrl
                    getMoviesFromRemote()
                }
                .doOnError { showError() }
                .subscribe()
    }

    private fun showUpcomingMovies(results: List<Movie>) {
        adapter.setData(results, secureBaseUrl)
    }

    private fun showError() {
        Toast.makeText(this, "Something went wrong. Check your connection and try again!", Toast.LENGTH_SHORT).show()
    }
}
