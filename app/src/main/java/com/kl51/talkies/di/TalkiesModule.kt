package com.kl51.talkies.di

import com.kl51.talkies.TalkiesApplication
import com.kl51.talkies.network.MovieApi
import com.kl51.talkies.utils.PreferenceUtils
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class TalkiesModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun providesMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

        @Provides
        @JvmStatic
        fun providePreferenceUtils(context: TalkiesApplication): PreferenceUtils = PreferenceUtils(context)
    }
}
