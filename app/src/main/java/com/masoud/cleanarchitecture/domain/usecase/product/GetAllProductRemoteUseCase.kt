package com.masoud.cleanarchitecture.domain.usecase.product

import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.data.repository.product.ProductRepository
import com.masoud.cleanarchitecture.utils.network.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.withContext

class GetAllProductRemoteUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(someData:String,pageNo:Int): Resource<List<Product>> = repository.getAllRemoteData(someData,pageNo)
}