package com.leandro.image_search.presentation.view.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leandro.image_search.domain.model.Image
import com.leandro.image_search.presentation.model.ImageSearchViewState
import com.leandro.image_search.presentation.ui.components.ImageItemCard

@Composable
internal fun ImageListView(
    modifier: Modifier = Modifier,
    state: State<ImageSearchViewState>,
    onImageTapped: (Image) -> Unit
) {
    LazyColumn(
        modifier
            .padding(5.dp)
            .fillMaxSize()
    ) {
        items(state.value.images) {
            Box(
                Modifier
                    .padding(5.dp)
                    .clickable { onImageTapped(it) }) {
                ImageItemCard(image = it)
            }
        }
    }
}