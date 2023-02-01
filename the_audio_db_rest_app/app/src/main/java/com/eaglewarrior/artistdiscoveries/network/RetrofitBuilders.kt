package com.eaglewarrior.artistdiscoveries.network

import com.eaglewarrior.artistdiscoveries.repositories.AudioDBService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Clarence E Moore on 2023-01-29.
 *
 * Description:
 *
 *
 */
class RetrofitBuilders {

    companion object{
        private const val BASE_URL = "https://theaudiodb.com/"
    }

    private val okHttpProviders = OkHttpProviders()

    private val okHttpClient = okHttpProviders.client

    private val retrofitBuilders = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    internal var audioDBService = retrofitBuilders.create(AudioDBService::class.java)

}
