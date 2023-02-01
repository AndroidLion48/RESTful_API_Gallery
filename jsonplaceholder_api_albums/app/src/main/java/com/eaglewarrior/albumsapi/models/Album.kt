package com.eaglewarrior.albumsapi.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Album(
    @SerializedName("id") val id: Int, // 35
    @SerializedName("title") val title: String, // et impedit nisi quae magni necessitatibus sed aut pariatur
    @SerializedName("userId") val userId: Int // 4
) : Parcelable
