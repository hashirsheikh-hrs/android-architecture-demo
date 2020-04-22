package com.hrs.di

import android.content.Context
import com.hrs.data.database.dao.GitRepoDao
import com.hrs.di.subcomponent.mainactivity.MainActivityComponent
import com.hrs.di.subcomponent.remote.AppRetrofitModule
import com.hrs.di.subcomponent.room.AppRoomModule
import com.hrs.data.remote.GitHubService
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppRetrofitModule::class, AppRoomModule::class,  AppSubComponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory

    fun gitRepoDao(): GitRepoDao

    fun gitHubService(): GitHubService
}