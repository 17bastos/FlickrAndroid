package com.leandro.image_search.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.leandro.image_search.di.ImageSearchKoinComponent
import com.leandro.image_search.domain.model.Image
import com.leandro.image_search.presentation.ui.theme.FlickrAndroidTheme
import com.leandro.image_search.presentation.view.ImageDetailView
import com.leandro.image_search.utils.unwrap

internal class ImageDetailActivity: ComponentActivity(), ImageSearchKoinComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageDetail: Image? = intent.extras?.getParcelable(IMAGE_DATA)

        enableEdgeToEdge()

        setContent {
            FlickrAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageDetailView(
                        modifier = Modifier.padding(innerPadding),
                        imageDetail.unwrap()
                    )
                }
            }
        }
    }

    companion object {
        private const val IMAGE_DATA = "IMAGE_DATA"
        fun start(context: Context, imageData: Image): Intent {
            return Intent(context, ImageDetailActivity::class.java).apply {
                putExtra(IMAGE_DATA, imageData)
            }
        }
    }
}