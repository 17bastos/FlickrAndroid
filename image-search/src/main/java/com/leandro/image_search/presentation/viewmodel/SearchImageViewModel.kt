package com.leandro.image_search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro.image_search.domain.model.Image
import com.leandro.image_search.domain.usecase.SearchImagesUseCase
import com.leandro.image_search.presentation.model.ImageSearchViewState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SearchImageViewModel(private val searchImagesUseCase: SearchImagesUseCase) :
    ViewModel() {
    private val _uiState: MutableStateFlow<ImageSearchViewState> = MutableStateFlow(ImageSearchViewState())
    val uiState = _uiState.asStateFlow()

    private val _navigateToSelectPhoto = MutableSharedFlow<Image>()
    val navigateToSelectPhoto = _navigateToSelectPhoto.asSharedFlow()
    
    fun search(s: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(search = s) }
            val result = searchImagesUseCase(uiState.value.search)
            _uiState.update { it.copy(images = result) }
        }
    }

    fun onPhotoTapped(image: Image) = viewModelScope.launch {
        _navigateToSelectPhoto.emit(image)
    }
}