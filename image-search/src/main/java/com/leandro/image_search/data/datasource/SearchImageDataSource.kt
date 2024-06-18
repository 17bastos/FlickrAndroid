package com.leandro.image_search.data.datasource

import com.leandro.image_search.domain.model.Image

internal interface SearchImageDataSource {
    suspend fun searchImages(search: String) : List<Image>
}
