package com.leandro.image_search.data.model

internal data class FlickrSearchResponse(
    val title: String? = null,
    val link: String? = null,
    val description: String? = null,
    val modified: String? = null,
    val generator: String? = null,
    val items: List<FlickrItemResponse>? = null,
)
