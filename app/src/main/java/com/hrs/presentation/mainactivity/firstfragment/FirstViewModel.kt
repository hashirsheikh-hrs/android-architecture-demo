package com.hrs.presentation.mainactivity.firstfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hrs.data.database.dao.GitRepoDao
import com.hrs.data.repository.GitRepoRepository
import com.hrs.model.GitHubRepo
import com.hrs.data.remote.GitHubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstViewModel constructor(application: Application, gitRepoDao: GitRepoDao, gitHubService: GitHubService) : AndroidViewModel(application){

    var repositry: GitRepoRepository = GitRepoRepository(gitRepoDao, gitHubService)

    lateinit var data: LiveData<List<GitHubRepo>>

    fun changeUser(user: String){
        data = repositry.changeListOfRepo(user)
        requestForUser(user)
    }

    private fun requestForUser(user: String){
        viewModelScope.launch(Dispatchers.IO){
            repositry.loadUserFromServer(user)
        }
    }

}