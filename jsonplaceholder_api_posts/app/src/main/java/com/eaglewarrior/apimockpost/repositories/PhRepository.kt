package com.eaglewarrior.apimockpost.repositories

import com.eaglewarrior.apimockpost.models.PostResponse
import com.eaglewarrior.apimockpost.network.RetrofitBuilders
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
        private val retrofitBuilder = RetrofitBuilders()
    }

    private val apiService by lazy {
        retrofitBuilder.apiService
    }

    suspend fun getPostByUserId(userId: Int): Response<PostResponse> = apiService.getPostsByUserId(userId)
}
