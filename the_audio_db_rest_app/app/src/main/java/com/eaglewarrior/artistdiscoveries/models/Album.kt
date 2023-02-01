package com.eaglewarrior.artistdiscoveries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    @SerializedName("intYearReleased") val intYearReleased: String, // 2020
    @SerializedName("strAlbum") val strAlbum: String // ADHD
) : Parcelable
