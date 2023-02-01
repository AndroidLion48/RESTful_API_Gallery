package com.eaglewarrior.mockapi.repositories.placeHolder

import com.eaglewarrior.mockapi.models.CommentResponse
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

    @GET("comments")
    suspend fun getComment(@Query("postId") postId: Int): Response<CommentResponse>

}
