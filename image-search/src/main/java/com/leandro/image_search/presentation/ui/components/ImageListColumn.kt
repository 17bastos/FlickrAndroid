package com.leandro.image_search.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leandro.image_search.domain.model.Image

@Composable
internal fun ImageListColumn(images: List<Image>) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(images) {
            ImageItemCard(it)
        }
    }
}