package com.leandro.image_search.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal object ServiceBuilder {
    inline fun <reified T> build(baseUrl: String): T =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(T::class.java)
}