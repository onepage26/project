package com.muhtarkhan.hw.Cart

import com.muhtarkhan.hw.Cart.Db.Entity.CartItem

data class CartState(
    val cartItems: List<CartItem> = emptyList()
)