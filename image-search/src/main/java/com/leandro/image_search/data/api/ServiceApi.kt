package com.leandro.image_search.data.api

import com.leandro.image_search.data.model.FlickrSearchResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

internal interface ServiceApi {

    @GET("photos_public.gne")
    suspend fun searchImages(
        @QueryMap options: Map<String, String?>
    ) : FlickrSearchResponse

    companion object {
        const val BASE_URL = "https://api.flickr.com/services/feeds/"
    }
}