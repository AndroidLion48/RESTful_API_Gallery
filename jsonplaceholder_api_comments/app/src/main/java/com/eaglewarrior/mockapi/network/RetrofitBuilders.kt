package com.eaglewarrior.mockapi.network

import com.eaglewarrior.mockapi.repositories.placeHolder.PhService
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
    // Create Companion Object
    companion object {

        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    //
    private val okHttpProvider = OkHttpProvider()
    private val buildClient = okHttpProvider.client
    private val buildRetrofit = Retrofit.Builder()
        .client(buildClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    internal var phService = buildRetrofit.create(PhService::class.java)

}
