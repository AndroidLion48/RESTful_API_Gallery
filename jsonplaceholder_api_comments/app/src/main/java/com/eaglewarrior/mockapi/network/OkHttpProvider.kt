package com.eaglewarrior.mockapi.network

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

    val client: OkHttpClient
    get() {
        val okBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)

        return okBuilder.build()
    }


    companion object {
        private const val WRITE_TIMEOUT = 60
        private const val READ_TIMEOUT = 120
        private const val CONNECT_TIMEOUT = 40

    }
}
