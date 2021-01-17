package com.kl51.talkies.di

import com.kl51.talkies.TalkiesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        TalkiesModule::class,
        ViewModelDiModule::class,
        ActivitiesDiModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: TalkiesApplication): Builder

        @BindsInstance
        fun baseUrl(@Named("baseUrl") baseUrl: String): Builder
    }

    fun inject(application: TalkiesApplication)
}
