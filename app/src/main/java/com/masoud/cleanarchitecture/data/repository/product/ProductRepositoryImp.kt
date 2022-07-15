package com.masoud.cleanarchitecture.data.repository.product

import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.data.repository.product.source.local.ProductLocalDataSource
import com.masoud.cleanarchitecture.data.repository.product.source.remote.ProductRemoteDataSource
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(private val remote: ProductRemoteDataSource, private val local:ProductLocalDataSource):ProductRepository {

    override suspend fun getAllRemoteData(someData: String, pageNo: Int): Resource<List<Product>> {
        return remote.getAllRemoteProducts(someData,pageNo)
    }

    override suspend fun getAllFavoriteProducts(): List<Product> {
        return local.getLocalFavoriteProducts()
    }

    override suspend fun isFavoriteProductExist(productId: String):Product {
        return local.isFavoriteProductExist(productId)?:Product()
    }

    override suspend fun addToFavorite(product: Product) {
        local.addToLocalFavorite(product)
    }

    override suspend fun deleteFromFavorite(product: Product) {
        local.deleteFromLocalFavorite(product)
    }

}