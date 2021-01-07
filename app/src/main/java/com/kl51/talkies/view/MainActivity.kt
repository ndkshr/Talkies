package com.kl51.talkies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kl51.talkies.R
import com.kl51.talkies.model.Movie
import com.kl51.talkies.utils.ViewModelFactory
import com.kl51.talkies.viewmodel.MainActivityViewModel
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
    }

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        compositeDisposable = CompositeDisposable()
        setContentView(R.layout.activity_main)
        viewModelSubscriptions()
    }

    private fun viewModelSubscriptions() {
        viewModel.getUpcomingMovies()
                .doOnSubscribe { compositeDisposable.add(it) }
                .doOnSuccess { showUpcomingMovies(it.results) }
                .doOnError { showError() }
                .subscribe()

//        viewModel.getConfiguration()
//                .doOnSubscribe { compositeDisposable.add(it) }
//                .doOnSuccess {  }
//                .doOnError {  }
//                .subscribe()
    }

    private fun showUpcomingMovies(results: List<Movie>) {
        Toast.makeText(this, "API call success : count - " + results.size, Toast.LENGTH_SHORT).show()
    }

    private fun showError() {
        Toast.makeText(this, "Check your connection and try again!", Toast.LENGTH_SHORT).show()
    }
}
