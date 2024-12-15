package com.muhtarkhan.hw.Cart.Db.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhtarkhan.hw.Cart.Db.Entity.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM CartItem")
    fun getCartItems(): List<CartItem>

    @Query("SELECT * FROM CartItem WHERE productId = :productId LIMIT 1")
    fun getCartItemById(productId: Int): CartItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(cartItem: CartItem)

    @Query("DELETE FROM cartitem WHERE productId = :productId")
    fun deleteCartItem(productId: Int)

    @Query("UPDATE cartitem SET quantity = quantity - 1 WHERE productId = :productId AND quantity > 0")
    fun decrementQuantity(productId: Int)
}