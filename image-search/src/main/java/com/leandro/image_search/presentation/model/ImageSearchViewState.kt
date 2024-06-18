package com.leandro.image_search.presentation.model

import com.leandro.image_search.domain.model.Image

internal data class ImageSearchViewState(
    val images: List<Image> = listOf(), val search: String = ""
) {
    val isEmpty: Boolean
        get() = images.isEmpty()
}
