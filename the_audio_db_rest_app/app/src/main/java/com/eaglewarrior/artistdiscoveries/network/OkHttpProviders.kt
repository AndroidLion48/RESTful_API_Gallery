package com.eaglewarrior.artistdiscoveries.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
class OkHttpProviders {

    val client: OkHttpClient
    get() {
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)

        return okHttpClient.build()
    }

    companion object{
        private const val WRITE_TIMEOUT = 60L
        private const val READ_TIMEOUT = 120L
        private const val CONNECT_TIMEOUT = 40L
    }
}
