package com.eaglewarrior.mockapi.repositories

import com.eaglewarrior.mockapi.models.CommentResponse
import com.eaglewarrior.mockapi.network.RetrofitBuilders
import com.eaglewarrior.mockapi.repositories.placeHolder.PhService
import retrofit2.Response

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
class PhRepository {
    companion object {
        private val retrofitBuilders: RetrofitBuilders = RetrofitBuilders()

    }

    private val phService: PhService by lazy {
        retrofitBuilders.phService
    }

    suspend fun getCommentsByPostId(postId: Int): Response<CommentResponse> = phService.getComment(postId)
}
