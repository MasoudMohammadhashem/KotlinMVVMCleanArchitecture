package com.masoud.cleanarchitecture.data.repository.product.source.remote

import com.google.gson.JsonObject
import com.masoud.cleanarchitecture.data.api.product.ProductApi
import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.data.repository.product.source.ProductDataSource
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ProductRemoteDataSourceImp @Inject constructor(private val productApi: ProductApi) : ProductRemoteDataSource {
    override suspend fun getAllRemoteProducts(someData:String, pageNo:Int): Resource<List<Product>> = productApi.getAllRemoteProducts(
        JsonObject().apply {
            addProperty("someData", someData)
            addProperty("pageNo", pageNo)
        })
}