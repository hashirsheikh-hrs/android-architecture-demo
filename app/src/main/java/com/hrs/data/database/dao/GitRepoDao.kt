package com.hrs.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hrs.model.GitHubRepo

@Dao
interface GitRepoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(gitHubRepo: List<GitHubRepo>)

    @Query("SELECT * FROM repository WHERE login=:user")
    fun getAllRepository(user: String): LiveData<List<GitHubRepo>>

    @Query("DELETE FROM repository")
    suspend fun deleteAll()
}