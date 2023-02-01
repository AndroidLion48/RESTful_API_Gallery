package com.eaglewarrior.retrofitcrashapp

import com.eaglewarrior.TodoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Clarence E Moore on 2023-01-15.
 *
 * Description:
 *
 *
 */
object RetrofitInstance {

    val api: TodoApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)
    }
}
