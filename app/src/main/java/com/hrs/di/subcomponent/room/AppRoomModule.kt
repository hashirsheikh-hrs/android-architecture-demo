package com.hrs.di.subcomponent.room

import android.content.Context
import androidx.room.Room
import com.hrs.data.database.AppDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppRoomModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        AppDB::class.java,
        "applicationDatabaseName"
    ).build()

    @Singleton
    @Provides
    fun getGitRepoDao(database: AppDB) = database.gitRepoDao()
}