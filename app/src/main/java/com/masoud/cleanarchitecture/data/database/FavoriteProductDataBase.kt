package com.masoud.cleanarchitecture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.masoud.cleanarchitecture.data.model.Product
import com.masoud.cleanarchitecture.data.repository.product.source.local.ProductLocalDataSource

@Database(entities = [Product::class], version = 1)
    abstract class FavoriteProductDataBase: RoomDatabase() {
        abstract fun ProductDao(): ProductLocalDataSource
    }
