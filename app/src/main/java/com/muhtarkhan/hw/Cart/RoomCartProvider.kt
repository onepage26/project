package com.muhtarkhan.hw.Cart

import android.content.Context
import com.muhtarkhan.hw.Cart.Db.Database.AppDataBase
import com.muhtarkhan.hw.Cart.Db.Entity.CartItem
import com.muhtarkhan.hw.Sneaker.ProductSource

class RoomCartProvider(context: Context) {

    private val cartDao = AppDataBase.getInstance(context.applicationContext).cartDao()

    fun getCartItems(): List<CartItem> {
        return cartDao.getCartItems().map { it.toCartItem() }
    }

    fun addToCart(productId: Int) {
        val sneaker = ProductSource.sneakers.first { it.id == productId }
        val existingItem = cartDao.getCartItemById(productId)
        val newQuantity = (existingItem?.quantity ?: 0) + 1

        val cartItem = CartItem(
            productId = sneaker.id,
            name = sneaker.name,
            description = sneaker.description,
            price = sneaker.price,
            image = sneaker.imageRes,
            quantity = newQuantity
        )
        cartDao.insertOrUpdate(cartItem)
    }

    fun removeFromCart(productId: Int) {
        val existingItem = cartDao.getCartItemById(productId)
        if (existingItem != null && existingItem.quantity > 1) {
            cartDao.decrementQuantity(productId)
        } else {
            cartDao.deleteCartItem(productId)
        }
    }

    private fun CartItem.toCartItem(): CartItem {
        return CartItem(
            productId = productId,
            name = name,
            description = description,
            price = price,
            image = image,
            quantity = quantity
        )
    }
}