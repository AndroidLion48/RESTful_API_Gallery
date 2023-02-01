package com.eaglewarrior.wallpapersktx.network

import com.eaglewarrior.wallpapersktx.model.Wallpaper
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Clarence E Moore on 2023-01-26.
 *
 * Description:
 *
 *
 */
interface ApiService {

    @Headers("Authorization: VkkZOlLYY7aZDlgRQJJLITaPBA5ZyrTY9zrQ7FqUXjOMrYGtJfcrZX2v")

    @GET("Random")
    suspend fun getHome(@Query("page") page: Int?) : Wallpaper

    @GET("Popular")
    suspend fun getPopular(@Query("page") page: Int?) : Wallpaper

    @GET("latest")
    suspend fun getLatest(@Query("page") page: Int?) : Wallpaper

    @GET("categories")
    suspend fun getCategories(
        @Query("page") page: Int?,
        @Query("category") category: String
        ) : Wallpaper
}
