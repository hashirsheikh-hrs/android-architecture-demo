package com.hrs

import android.app.Application
import com.hrs.di.AppComponent
import com.hrs.di.DaggerAppComponent

open class MainApplication : Application(){

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory()
        .create(this)
    }
}