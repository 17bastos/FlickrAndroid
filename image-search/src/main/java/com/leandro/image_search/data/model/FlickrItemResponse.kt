package com.leandro.image_search.data.model

import com.google.gson.annotations.SerializedName

internal data class FlickrItemResponse(
    val title: String? = null,
    val link: String? = null,
    val media: FlickrMediaResponse? = null,
    @SerializedName("date_taken")
    val dateTaken: String? = null,
    val description: String? = null,
    val published: String? = null,
    val author: String? = null,
    @SerializedName("author_id")
    val authorId: String? = null,
    val tags: String? = null,
)
