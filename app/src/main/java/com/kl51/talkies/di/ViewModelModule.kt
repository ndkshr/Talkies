package com.kl51.talkies.di

import androidx.lifecycle.ViewModelProvider
import com.kl51.talkies.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}