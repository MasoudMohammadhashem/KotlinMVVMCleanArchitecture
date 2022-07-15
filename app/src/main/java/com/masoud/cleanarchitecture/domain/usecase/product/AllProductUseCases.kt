package com.masoud.cleanarchitecture.domain.usecase.product

data class AllProductUseCases(
    val isFavoriteProductExistUseCase : IsFavoriteProductExistUseCase,
    val addLocalFavoriteProduct : AddProductToFavoriteUseCase,
    val deleteLocalFavoriteProduct : DeleteProductFromFavoriteUseCase,
    val getAllRemoteProducts : GetAllProductRemoteUseCase,
    val getAllLocalFavoriteProducts : GetAllProductLocalUseCase
)
