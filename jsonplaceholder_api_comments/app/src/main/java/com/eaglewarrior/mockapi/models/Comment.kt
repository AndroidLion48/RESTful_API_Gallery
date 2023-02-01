package com.eaglewarrior.mockapi.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

/**
 * Created by Clarence E Moore on 2023-01-28.
 *
 * Description:
 *
 *
 */
@Parcelize
data class Comment(

    @SerializedName("postId")
    val postId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("body")
    val body: String

) : Parcelable
