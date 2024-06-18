package com.leandro.image_search.domain.usecase

internal class GetImageSizeUseCase {
    operator fun invoke(text: String) : String? {
        val width = text.substringAfter("width=").substringBefore(" ")
        val height = text.substringAfter("height=").substringBefore(" ")

        return if (width.isNotEmpty() && height.isNotEmpty()) {
            "$width x $height"
        } else null
    }
}