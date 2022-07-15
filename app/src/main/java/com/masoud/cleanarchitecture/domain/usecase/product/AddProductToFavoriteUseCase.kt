package com.masoud.cleanarchitecture.domain.usecase.product

import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.data.repository.product.ProductRepository

class AddProductToFavoriteUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(product: Product) = repository.addToFavorite(product)
}