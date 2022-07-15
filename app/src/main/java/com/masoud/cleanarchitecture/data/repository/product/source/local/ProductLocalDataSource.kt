package com.masoud.cleanarchitecture.data.repository.product.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.data.repository.product.source.ProductDataSource
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface ProductLocalDataSource : ProductDataSource {

    override suspend fun getAllRemoteProducts(someData:String, pageNo:Int): Resource<List<Product>> { TODO("Not yet implemented") }

    @Query("SELECT * FROM ProductTbl")
    override suspend fun getLocalFavoriteProducts(): List<Product>

    @Query("SELECT * FROM ProductTbl where productId = :productId")
    override suspend fun isFavoriteProductExist(productId:String): Product?

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    override suspend fun addToLocalFavorite(product: Product)

    @Delete
    override suspend fun deleteFromLocalFavorite(product: Product)
}