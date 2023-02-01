package com.eaglewarrior.apimockpost.network

import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.*
import java.util.concurrent.TimeUnit

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
class OkHttpProvider {

    val okHttpClient : OkHttpClient
    get() {
        val okBuilder = Builder()
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)

        return okBuilder.build()
    }

    companion object{
        private const val WRITE_TIMEOUT = 60L
        private const val CONNECT_TIMEOUT = 40L
        private const val READ_TIMEOUT = 120L

    }
}
