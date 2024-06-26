package com.leandro.image_search.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailText(text: String) {
    Text(modifier = Modifier.padding(top = 5.dp), text = text)
}