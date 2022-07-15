package com.masoud.cleanarchitecture.data.api.product

import com.google.gson.JsonObject
import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.http.Body
import retrofit2.http.POST

interface ProductApi {
    @POST("product")
    suspend fun getAllRemoteProducts(@Body jsonObject: JsonObject): Resource<List<Product>>

}