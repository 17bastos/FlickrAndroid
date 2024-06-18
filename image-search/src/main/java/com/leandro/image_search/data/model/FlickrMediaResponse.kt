package com.leandro.image_search.data.model

import com.google.gson.annotations.SerializedName


internal data class FlickrMediaResponse(
    @SerializedName("m")
    val link: String? = null
)

