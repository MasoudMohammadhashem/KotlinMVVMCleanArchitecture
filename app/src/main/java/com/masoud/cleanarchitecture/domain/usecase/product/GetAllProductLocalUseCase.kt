package com.masoud.cleanarchitecture.domain.usecase.product

import com.masoud.cleanarchitecture.data.repository.product.ProductRepository

class GetAllProductLocalUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke() = repository.getAllFavoriteProducts()
}