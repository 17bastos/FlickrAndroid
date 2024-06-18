package com.leandro.image_search.utils

import com.leandro.image_search.domain.model.Image

internal fun String?.unwrap(default: String = "") : String {
    return this?:default
}

internal fun Image?.unwrap(): Image {
    return this?:Image("", "", "", "", "", "", "", "", listOf(), "")
}