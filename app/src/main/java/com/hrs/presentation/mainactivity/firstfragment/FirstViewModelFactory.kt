package com.hrs.presentation.mainactivity.firstfragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hrs.data.database.dao.GitRepoDao
import com.hrs.data.remote.GitHubService

class FirstViewModelFactory constructor(private val application: Application, private val gitRepoDao: GitRepoDao, private val gitHubService: GitHubService): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>) = FirstViewModel(
        application,
        gitRepoDao,
        gitHubService
    ) as T
}