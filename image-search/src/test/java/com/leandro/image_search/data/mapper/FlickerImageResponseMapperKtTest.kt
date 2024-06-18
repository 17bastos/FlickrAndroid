package com.leandro.image_search.data.mapper

import com.leandro.image_search.data.model.FlickrItemResponse
import com.leandro.image_search.data.model.FlickrMediaResponse
import com.leandro.image_search.data.model.FlickrSearchResponse
import com.leandro.image_search.domain.model.Image
import org.junit.Assert.*
import org.junit.Test

class FlickerImageResponseMapperKtTest {
    @Test
    fun `assert FlickerImageResponse to ImageListDomain`() {
        // GIVEN
        val expectedResult = listOf(
            Image(
                title = "titleItem",
                link = "linkItem",
                mediaLink = "mediaLink",
                dateTaken = "dateTaken",
                publicationDate = "06/16/2024 13:57:19",
                author = "author",
                authorId = "authorId",
                tags = listOf("tag1", "tag2"),
                size = "\"240\" x \"174\"",
                description = "description width=\"240\" height=\"174\"",
            )
        )
        val flickrItemResponse = FlickrItemResponse(
            title = "titleItem",
            link = "linkItem",
            media = FlickrMediaResponse(link = "mediaLink"),
            dateTaken = "dateTaken",
            description = "description width=\"240\" height=\"174\"",
            published = "2024-06-16T13:57:19Z",
            author = "author",
            authorId = "authorId",
            tags = "tag1 tag2"
        )
        val flickerImageResponse = FlickrSearchResponse(
            title = "title",
            link = "link",
            description = "description",
            modified = "modified",
            generator = "generator",
            items = listOf(flickrItemResponse),
        )

        // WHEN
        val result = flickerImageResponse.toImageListDomain()

        // THEN
        assertEquals(expectedResult, result)
    }
}