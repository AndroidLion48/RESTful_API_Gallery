package com.eaglewarrior.albumsapi.network

import com.eaglewarrior.albumsapi.repositories.PhService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
class RetrofitBuilders {

    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    private val okHttpProvider = OkHttpProvider()
    private val okHttpClient = okHttpProvider.httpClient

    private val retrofitBuilders = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    internal var phService = retrofitBuilders.create(PhService::class.java)
}
