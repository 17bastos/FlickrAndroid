package com.leandro.image_search.domain.usecase

import com.leandro.image_search.data.datasource.SearchImageDataSource
import com.leandro.image_search.domain.model.Image

internal class SearchImagesUseCase(private val imageDataSource: SearchImageDataSource) {
    suspend operator fun invoke(search: String): List<Image> {
        val regex = Regex("\\s+")
        return imageDataSource.searchImages(search.replace(regex, ","))
    }
}