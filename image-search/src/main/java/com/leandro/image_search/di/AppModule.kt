package com.leandro.image_search.di

import com.leandro.image_search.data.ServiceBuilder
import com.leandro.image_search.data.api.ServiceApi
import com.leandro.image_search.data.datasource.SearchImageDataSource
import com.leandro.image_search.data.datasource.SearchImageDataSourceImpl
import com.leandro.image_search.domain.usecase.SearchImagesUseCase
import com.leandro.image_search.presentation.viewmodel.SearchImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val serviceModule = module {
    single {
        ServiceBuilder.build<ServiceApi>(ServiceApi.BASE_URL)
    }
}

internal val dataSourceModule = module {
    factory<SearchImageDataSource> { SearchImageDataSourceImpl(get()) }
}

internal val useCaseModule = module {
    factory<SearchImagesUseCase> {SearchImagesUseCase(imageDataSource = get()) }
}

internal val viewModelModule = module {
    viewModel { SearchImageViewModel(get()) }
}

internal val allModules = listOf(
    serviceModule,
    dataSourceModule,
    useCaseModule,
    viewModelModule
)