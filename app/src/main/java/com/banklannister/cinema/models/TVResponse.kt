package com.banklannister.cinema.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVResponse(
    @SerializedName("results")
    val tv: List<TV>
) : Parcelable {
    constructor() : this(mutableListOf())
}