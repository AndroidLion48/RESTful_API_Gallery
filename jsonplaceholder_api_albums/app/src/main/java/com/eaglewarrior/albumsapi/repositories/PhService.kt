package com.eaglewarrior.albumsapi.repositories

import com.eaglewarrior.albumsapi.models.AlbumsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
interface PhService {

    @GET("albums") // THIS IS THE END POINT
    suspend fun getAlbumById(@Query("id") Id: Int): Response<AlbumsResponse>
}
