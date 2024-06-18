package com.leandro.flickrandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.leandro.image_search.SearchImageModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchImageModule.launch(this)
        finish()
    }
}