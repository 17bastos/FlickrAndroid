package com.leandro.image_search.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.leandro.image_search.di.ImageSearchKoinComponent
import com.leandro.image_search.domain.model.Image
import com.leandro.image_search.presentation.ui.theme.FlickrAndroidTheme
import com.leandro.image_search.presentation.view.SearchImageView
import com.leandro.image_search.presentation.viewmodel.SearchImageViewModel
import com.leandro.image_search.utils.launchAndCollectIn
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SearchImageActivity : ComponentActivity(), ImageSearchKoinComponent {

    private val viewModel: SearchImageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEvents()
        enableEdgeToEdge()
        setContent {
            FlickrAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchImageView(
                        modifier = Modifier.padding(innerPadding),
                        state = viewModel.uiState.collectAsState(),
                        onSearch = viewModel::search,
                        onImageTapped = viewModel::onPhotoTapped
                    )
                }
            }
        }
    }

    private fun observeEvents() {
        viewModel.navigateToSelectPhoto.launchAndCollectIn(this) {
            startActivity(ImageDetailActivity.start(this@SearchImageActivity, it))
        }
    }
}