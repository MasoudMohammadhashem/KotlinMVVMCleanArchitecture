package com.masoud.cleanarchitecture.data.di

import com.masoud.cleanarchitecture.utils.const.BASE_URL
import com.masoud.cleanarchitecture.data.api.product.ProductApi
import com.masoud.cleanarchitecture.data.repository.product.source.remote.ProductRemoteDataSource
import com.masoud.cleanarchitecture.data.repository.product.source.remote.ProductRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {


    @Singleton
    @Provides
    fun provideProductApi(): ProductApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteProductDataSource(productApi: ProductApi): ProductRemoteDataSource = ProductRemoteDataSourceImp(productApi)

}