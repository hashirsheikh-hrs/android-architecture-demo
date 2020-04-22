package com.hrs.di.subcomponent.remote

import com.hrs.data.remote.GitHubService
import com.hrs.data.remote.NULL_TO_DEFAULT_ADAPTER
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class AppRetrofitModule {
    private val BASE_URL = "https://api.github.com/"

    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory): Retrofit =
        Retrofit
            .Builder()
            .addConverterFactory(moshiConverterFactory)
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun getMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory = MoshiConverterFactory.create(moshi)

    @Singleton
    @Provides
    fun getMoshi(): Moshi = Moshi.Builder()
        .add(NULL_TO_DEFAULT_ADAPTER)
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    open fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    open fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun getGithubService(retrofit: Retrofit): GitHubService = retrofit.create(
        GitHubService::class.java)
}