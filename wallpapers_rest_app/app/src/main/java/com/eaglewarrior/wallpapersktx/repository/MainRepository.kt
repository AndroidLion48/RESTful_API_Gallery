package com.eaglewarrior.wallpapersktx.repository

import com.eaglewarrior.wallpapersktx.network.ApiService
import com.eaglewarrior.wallpapersktx.network.Retrofit

/**
 * Created by Clarence E Moore on 2023-01-27.
 *
 * Description:
 *
 *
 */
class MainRepository {

    fun apiService(): ApiService = Retrofit.apiService
}
