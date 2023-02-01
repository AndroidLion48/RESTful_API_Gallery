package com.eaglewarrior.artistdiscoveries.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistAlbumsResponse(
    @SerializedName("album") val album: List<Album>
) : Parcelable
