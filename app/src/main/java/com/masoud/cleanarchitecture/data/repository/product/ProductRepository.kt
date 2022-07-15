package com.masoud.cleanarchitecture.data.repository.product

import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface ProductRepository {

    suspend fun getAllRemoteData(someData:String , pageNo:Int) : Resource<List<Product>>

    suspend fun getAllFavoriteProducts() : List<Product>

    suspend fun isFavoriteProductExist(productId : String):Product?

    suspend fun addToFavorite(product : Product)

    suspend fun deleteFromFavorite(product: Product)
}