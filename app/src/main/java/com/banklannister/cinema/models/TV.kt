package com.banklannister.cinema.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TV(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val title: String?,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("overview")
    val overview: String?

) : Parcelable {
    constructor() : this("", "", "", "")
}