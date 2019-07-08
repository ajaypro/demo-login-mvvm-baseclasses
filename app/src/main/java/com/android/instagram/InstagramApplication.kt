package com.android.instagram

import android.app.Application
import com.android.instagram.di.component.ApplicationComponent
import com.android.instagram.di.component.DaggerApplicationComponent
import com.android.instagram.di.module.ApplicationModule

class InstagramApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}