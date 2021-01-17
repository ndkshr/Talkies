package com.kl51.talkies.di

import androidx.lifecycle.ViewModel
import com.kl51.talkies.utils.ViewModelKey
import com.kl51.talkies.viewmodel.MainActivityViewModel
import com.kl51.talkies.viewmodel.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelDiModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun providesMainActivityViewModel(weatherViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun providesMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel
}
