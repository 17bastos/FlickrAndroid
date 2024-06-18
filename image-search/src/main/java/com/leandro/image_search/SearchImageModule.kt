package com.leandro.image_search

import android.content.Context
import android.content.Intent
import com.leandro.image_search.di.ImageSearchKoinApplication
import com.leandro.image_search.presentation.activity.SearchImageActivity

object SearchImageModule {
    fun launch(context: Context) {
        ImageSearchKoinApplication.initialize(context)
        context.startActivity(Intent(context, SearchImageActivity::class.java))
    }
}