package com.masoud.cleanarchitecture.data.repository.product.source.local

import com.masoud.cleanarchitecture.data.database.FavoriteProductDataBase
import com.masoud.cleanarchitecture.data.model.Product
import javax.inject.Inject

class ProductLocalDataSourceImp @Inject constructor(private val dataBase:FavoriteProductDataBase):ProductLocalDataSource{
    private val dao = dataBase.ProductDao()
    override suspend fun getLocalFavoriteProducts(): List<Product> {
        return dao.getLocalFavoriteProducts()
    }

    override suspend fun isFavoriteProductExist(productId: String): Product? {
        return dao.isFavoriteProductExist(productId)
    }

    override suspend fun addToLocalFavorite(product: Product) {
        return dao.addToLocalFavorite(product)
    }

    override suspend fun deleteFromLocalFavorite(product: Product) {
        return dao.deleteFromLocalFavorite(product)
    }
}