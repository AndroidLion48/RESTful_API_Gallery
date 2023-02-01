package com.eaglewarrior.artistdiscoveries.repositories

import com.eaglewarrior.artistdiscoveries.models.ArtistAlbumsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Clarence E Moore on 2023-01-29.
 *
 * Description:
 *
 *
 */
interface AudioDBService {

    @GET("api/v1/json/2/discography.php")
    suspend fun getAlbumsByArtist(@Query("s") name: String): Response<ArtistAlbumsResponse>
}
