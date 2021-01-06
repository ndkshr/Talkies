package com.kl51.talkies


import android.app.Activity
import android.app.Application
import com.kl51.talkies.di.AppComponent
import com.kl51.talkies.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class TalkiesApplication : Application(), HasActivityInjector {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org"
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    private lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        getComponent().inject(this)
    }

    open fun getComponent(): AppComponent {
        if (!this::applicationComponent.isInitialized) {
            applicationComponent = DaggerAppComponent.builder()
                .application(this)
                .baseUrl(BASE_URL)
                .build()
        }
        return applicationComponent
    }
}
