package com.leandro.image_search.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.leandro.image_search.domain.model.Image
import com.leandro.image_search.presentation.model.ImageSearchViewState
import com.leandro.image_search.presentation.view.screen.EmptyView
import com.leandro.image_search.presentation.view.screen.ImageListView

@Composable
internal fun SearchImageView(
    modifier: Modifier = Modifier,
    state: State<ImageSearchViewState>,
    onSearch: (String) -> Unit,
    onImageTapped: (Image) -> Unit
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = state.value.search, onValueChange = onSearch)
        when {
            state.value.isEmpty -> EmptyView()
            else -> ImageListView(state = state, onImageTapped = onImageTapped)
        }
    }
}