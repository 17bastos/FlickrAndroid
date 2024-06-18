package com.leandro.image_search.data.datasource

import com.leandro.image_search.data.api.ServiceApi
import com.leandro.image_search.data.mapper.toImageListDomain
import com.leandro.image_search.domain.model.Image

internal class SearchImageDataSourceImpl(private val api: ServiceApi): SearchImageDataSource {
    override suspend fun searchImages(search: String): List<Image> {
        val options = mutableMapOf<String,String>()
        options["format"] = "json"
        options["nojsoncallback"] = "1"
        options["tags"] = search
        options["tagmode"] = "any"
        val response = api.searchImages(options)
        return response.toImageListDomain()
    }
}