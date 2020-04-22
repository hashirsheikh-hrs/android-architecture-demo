package com.hrs.data.remote

import com.hrs.model.GitHubRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/repos")
    suspend fun listRepository(@Path("user") user: String): List<GitHubRepo>

}