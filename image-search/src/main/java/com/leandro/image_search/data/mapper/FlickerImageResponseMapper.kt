package com.leandro.image_search.data.mapper

import com.leandro.image_search.data.model.FlickrSearchResponse
import com.leandro.image_search.domain.model.Image
import com.leandro.image_search.utils.toFormattedDate
import com.leandro.image_search.utils.unwrap

internal fun FlickrSearchResponse.toImageListDomain(): List<Image> {
    return this.items?.map {
        Image(
            title = it.title.unwrap(),
            author = it.author.unwrap(),
            authorId = it.authorId.unwrap(),
            dateTaken = it.dateTaken.unwrap(),
            description = it.description.unwrap(),
            publicationDate = it.published.toFormattedDate(),
            link = it.link.unwrap(),
            mediaLink = it.media?.link.unwrap(),
            tags = it.tags.unwrap().split(" "),
            size = it.description.getSizeOrEmpty()
        )
    } ?: listOf()
}

private fun String?.getSizeOrEmpty(): String {
    val width = this?.substringAfter("width=")?.substringBefore(" ")
    val height = this?.substringAfter("height=")?.substringBefore(" ")

    return if (!width.isNullOrEmpty() && !height.isNullOrEmpty()) {
        "$width x $height"
    } else "N/A"
}