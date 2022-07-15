package com.masoud.cleanarchitecture.domain.di

import com.masoud.cleanarchitecture.data.repository.product.ProductRepository
import com.masoud.cleanarchitecture.domain.usecase.product.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideProductUseCase(repository: ProductRepository) =
        AllProductUseCases(
            IsFavoriteProductExistUseCase(repository),
            AddProductToFavoriteUseCase(repository),
            DeleteProductFromFavoriteUseCase(repository),
            GetAllProductRemoteUseCase(repository),
            GetAllProductLocalUseCase(repository)
        )
}