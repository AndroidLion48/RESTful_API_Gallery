package com.eaglewarrior.apimockpost.repositories

import com.eaglewarrior.apimockpost.models.Post
import com.eaglewarrior.apimockpost.models.PostResponse
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
interface ApiService {

    @GET("/posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): Response<PostResponse>

}
