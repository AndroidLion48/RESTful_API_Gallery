package com.eaglewarrior

import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Clarence E Moore on 2023-01-15.
 *
 * Description:
 *
 *
 */
interface TodoApi {

    @GET("/todos")
    suspend fun getTodos(): Response<List<TodoResponseItem>>

}
