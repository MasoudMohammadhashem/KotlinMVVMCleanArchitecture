package com.masoud.cleanarchitecture.presentation.ui.fragment.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.utils.network.Resource
import com.masoud.cleanarchitecture.domain.usecase.product.AllProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCases: AllProductUseCases) : ViewModel() {

    private var _remoteStateFlow = MutableStateFlow<List<Product>>(emptyList())
    val remoteStateFlow = _remoteStateFlow.asStateFlow()

    private var _errorHandler = MutableSharedFlow<String>()
    val errorHandler = _errorHandler.asSharedFlow()

    private var _progressHandler = MutableStateFlow<Boolean>(false)
    val progressHandler = _progressHandler.asStateFlow()

    private val _localStateFlow = MutableStateFlow<List<Product>>(emptyList())
    val localStateFlow = _localStateFlow.asStateFlow()


//HANDLE ERROR WITH CoroutineExceptionHandler (WITHOUT TRY/CATCH)
/*
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch(Dispatchers.IO) {

            _errorHandler.emit(exception.cause?.message?:"Unknown Error Acquired")
        }
    }
*/

    fun getAllRemoteData() {
        viewModelScope.launch(Dispatchers.IO) {
            _progressHandler.emit(true)
            delay(2000L)
            try {
                when(val result  = useCases.getAllRemoteProducts.invoke("someData", 1))
                {
                    is Resource.Success ->
                        result.data?.let { _remoteStateFlow.emit(it) }
                    is Resource.Error ->
                        _errorHandler.emit(result.message?:"Unknown Error Acquired")
                }
            }catch (e:Exception){
                _errorHandler.emit(e.message?:"Unknown Error Acquired")
            }finally {
                _progressHandler.emit(false)
            }
        }
    }

    fun getAllLocalData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result  = useCases.getAllLocalFavoriteProducts.invoke()
                _localStateFlow.emit(result)
            }catch (e:Exception){
                _errorHandler.emit(e.message?:"Unknown Error Acquired")
            }
        }
    }


    fun addOneProductToFavoriteDataBase(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val mockProduct = Product("2","Number2",99.99,"")
                val result  = useCases.addLocalFavoriteProduct.invoke(mockProduct)
                _errorHandler.emit(result.toString())
            }catch (e:Exception){
                _errorHandler.emit(e.message?:"Unknown Error Acquired")
            }
        }
    }
}