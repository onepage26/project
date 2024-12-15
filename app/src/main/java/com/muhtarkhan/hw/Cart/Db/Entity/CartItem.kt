package com.muhtarkhan.hw.Cart.Db.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CartItem")
data class CartItem(
    @PrimaryKey val productId: Int,
    val name: String,
    val description: String,
    val price: String,
    val image: Int,
    val quantity: Int
)