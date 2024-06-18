package com.leandro.image_search.utils

import java.text.SimpleDateFormat
import java.util.Locale

internal fun String?.toFormattedDate() : String {
    return try {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date = formatter.parse(this)

        val desiredFormat = "MM/dd/yyyy HH:mm:ss"
        val newFormatter = SimpleDateFormat(desiredFormat, Locale.getDefault())
        val formattedDate = newFormatter.format(date)
        return formattedDate
    } catch (e : Throwable) {
        print(e)
        return "N/A"
    }
}