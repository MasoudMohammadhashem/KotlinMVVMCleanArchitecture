package com.masoud.cleanarchitecture.data.repository.product.source

import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface ProductDataSource {

    suspend fun getAllRemoteProducts(someData:String, pageNo:Int) : Resource<List<Product>>

    suspend fun getLocalFavoriteProducts() : List<Product>

    suspend fun isFavoriteProductExist(productId : String) : Product?

    suspend fun addToLocalFavorite(product : Product)

    suspend fun deleteFromLocalFavorite(product: Product)
}