package com.eaglewarrior.mockapi.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class TacosItem(
    @SerializedName("body") val body: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("postId") val postId: Int?
) : Parcelable
