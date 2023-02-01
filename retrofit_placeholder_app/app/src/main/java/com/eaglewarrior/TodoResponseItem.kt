package com.eaglewarrior


data class TodoResponseItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)
