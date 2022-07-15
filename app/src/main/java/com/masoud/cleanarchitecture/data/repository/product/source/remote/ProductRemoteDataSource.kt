package com.masoud.cleanarchitecture.data.repository.product.source.remote

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.data.repository.product.source.ProductDataSource
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface ProductRemoteDataSource : ProductDataSource {

    override suspend fun getAllRemoteProducts(someData: String, pageNo: Int): Resource<List<Product>>

    override suspend fun isFavoriteProductExist(productId: String): Product? { TODO("Not yet implemented") }

    override suspend fun getLocalFavoriteProducts(): List<Product> { TODO("Not yet implemented") }

    override suspend fun addToLocalFavorite(product: Product) { TODO("Not yet implemented") }

    override suspend fun deleteFromLocalFavorite(product: Product) { TODO("Not yet implemented") }
}