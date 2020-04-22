package com.hrs.data.repository

import com.hrs.data.database.dao.GitRepoDao
import com.hrs.data.remote.GitHubService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitRepoRepository @Inject constructor(val dao: GitRepoDao, val service: GitHubService) {

    fun changeListOfRepo(user: String) = dao.getAllRepository(user)

    suspend fun loadUserFromServer(user: String) {
        val data = service.listRepository(user)
        dao.insertAll(data)
    }

}