package com.kl51.talkies.di

import com.kl51.talkies.view.MainActivity
import com.kl51.talkies.view.MovieDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesDiModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeMovieDetailsActivity(): MovieDetailsActivity
}
