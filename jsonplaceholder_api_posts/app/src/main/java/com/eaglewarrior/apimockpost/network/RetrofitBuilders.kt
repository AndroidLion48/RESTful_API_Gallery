package com.eaglewarrior.apimockpost.network

import com.eaglewarrior.apimockpost.repositories.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
class RetrofitBuilders {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    private val okHttpProvider = OkHttpProvider()

    private val buildClient = okHttpProvider.okHttpClient

    private val buildRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(buildClient)
        .build()

    internal var apiService = buildRetrofit.create(ApiService::class.java)
}
