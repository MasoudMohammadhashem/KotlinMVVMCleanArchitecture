package com.masoud.cleanarchitecture.data.di

import com.masoud.cleanarchitecture.data.repository.product.ProductRepository
import com.masoud.cleanarchitecture.data.repository.product.ProductRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindProductRepository(repository: ProductRepositoryImp): ProductRepository

}