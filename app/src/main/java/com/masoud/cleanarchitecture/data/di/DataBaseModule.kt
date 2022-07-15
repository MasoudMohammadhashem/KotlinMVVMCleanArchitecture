package com.masoud.cleanarchitecture.data.di

import android.content.Context
import androidx.room.Room
import com.masoud.cleanarchitecture.data.database.FavoriteProductDataBase
import com.masoud.cleanarchitecture.data.repository.product.source.local.ProductLocalDataSource
import com.masoud.cleanarchitecture.data.repository.product.source.local.ProductLocalDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, FavoriteProductDataBase::class.java, "FavoriteProductDataBase"
    ).fallbackToDestructiveMigration().allowMainThreadQueries()
        .build()

    @Singleton
    @Provides
    fun provideLocalProductDataSource(dataBase: FavoriteProductDataBase):ProductLocalDataSource = ProductLocalDataSourceImp(dataBase)

}