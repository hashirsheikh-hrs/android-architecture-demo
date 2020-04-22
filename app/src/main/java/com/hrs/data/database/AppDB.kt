package com.hrs.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hrs.data.database.dao.GitRepoDao
import com.hrs.model.GitHubRepo
import javax.inject.Singleton

@Singleton
@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase(){
    abstract fun gitRepoDao(): GitRepoDao

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: AppDB? = null
//
//        fun getDatabase(context: Context): AppDB {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDB::class.java,
//                    "applicationDatabaseName"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }

}