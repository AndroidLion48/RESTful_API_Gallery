package com.eaglewarrior.artistdiscoveries.repositories

import com.eaglewarrior.artistdiscoveries.models.ArtistAlbumsResponse
import com.eaglewarrior.artistdiscoveries.network.RetrofitBuilders
import retrofit2.Response

/**
 * Created by Clarence E Moore on 2023-01-29.
 *
 * Description:
 *
 *
 */
class AudioDBRepository {

    companion object{
        private val retrofitBuilders = RetrofitBuilders()
    }

    private val audioDBService: AudioDBService by lazy {
        retrofitBuilders.audioDBService
    }

    suspend fun getAlbumByArtist(name: String): Response<ArtistAlbumsResponse> = audioDBService.getAlbumsByArtist(name)
}
