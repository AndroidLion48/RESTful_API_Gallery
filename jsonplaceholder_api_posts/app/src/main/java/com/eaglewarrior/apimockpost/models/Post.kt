package com.eaglewarrior.apimockpost.models


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Post(
    @SerializedName("body") val body: String, // repellat aliquid praesentium dolorem quosed totam minus non itaquenihil labore molestiae sunt dolor eveniet hic recusandae veniamtempora et tenetur expedita sunt
    @SerializedName("id") val id: Int, // 21
    @SerializedName("title") val title: String, // asperiores ea ipsam voluptatibus modi minima quia sint
    @SerializedName("userId") val userId: Int // 3
) : Parcelable
