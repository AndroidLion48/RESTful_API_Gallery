package com.eaglewarrior.wallpapersktx.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Clarence E Moore on 2023-01-26.
 *
 * Description:
 *
 *
 */
object Retrofit {

    private const val BASE_URL = "https://api.pexels.com/v1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService : ApiService = retrofit.create(ApiService::class.java)
}
