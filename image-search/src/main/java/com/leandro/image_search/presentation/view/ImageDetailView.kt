package com.leandro.image_search.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leandro.image_search.domain.model.Image
import com.leandro.image_search.presentation.ui.components.DetailText
import com.leandro.image_search.presentation.ui.components.ImageItemCard

@Composable
internal fun ImageDetailView(
    modifier: Modifier = Modifier,
    image: Image
) {
    Column(modifier = modifier.padding(20.dp)) {
        ImageItemCard(image = image)
        DetailText("Title: ${image.title}")
        DetailText("Author: ${image.author}")
        DetailText("Published Date: ${image.publicationDate}")
        DetailText("Size: ${image.size}")
    }
}