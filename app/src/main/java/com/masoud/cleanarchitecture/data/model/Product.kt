package com.masoud.cleanarchitecture.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "ProductTbl")
@Parcelize
data class Product(
    @PrimaryKey
    val productId: String="0",
    val productName: String="null",
    val productPrice: Double=0.0,
    val productDetail: String="null"
): Parcelable {
    var isFavorite: Boolean = false
}
