package com.eaglewarrior.albumsapi.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
class OkHttpProvider {

    val httpClient: OkHttpClient
    get() {
        val okHttpClient : OkHttpClient.Builder =  OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)

        return okHttpClient.build()
    }

    companion object{
        private val READ_TIMEOUT = 60L
        private val WRITE_TIMEOUT = 120L
        private val CONNECT_TIMEOUT = 40L
    }
}
