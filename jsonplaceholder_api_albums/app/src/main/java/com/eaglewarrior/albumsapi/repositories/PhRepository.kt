package com.eaglewarrior.albumsapi.repositories

import com.eaglewarrior.albumsapi.models.AlbumsResponse
import com.eaglewarrior.albumsapi.network.RetrofitBuilders
import retrofit2.Response

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
class PhRepository {

    companion object{
        private val retrofitBuilders = RetrofitBuilders()
    }

    private val phService: PhService by lazy {
        retrofitBuilders.phService
    }

    suspend fun getAlbumsById(id: Int): Response<AlbumsResponse> = phService.getAlbumById(id)

}
