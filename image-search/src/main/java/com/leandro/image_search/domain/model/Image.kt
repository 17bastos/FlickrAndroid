package com.leandro.image_search.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Image(
    val title: String,
    val link: String,
    val mediaLink: String,
    val dateTaken: String,
    val description: String,
    val publicationDate: String,
    val author: String,
    val authorId: String,
    val tags: List<String>,
    val size: String
) : Parcelable
