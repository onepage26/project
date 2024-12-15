package com.muhtarkhan.hw.Cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CartViewModel(
    private val cartProvider: RoomCartProvider,
) : ViewModel() {

    var state: CartState by mutableStateOf(CartState())
        private set

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        state = state.copy(
            cartItems = cartProvider.getCartItems()
        )
    }

    fun dispatch(event: CartEvent) {
        when (event) {
            is CartEvent.AddToCart -> {
                cartProvider.addToCart(event.productId)
                loadCartItems()
            }
            is CartEvent.RemoveFromCart -> {
                cartProvider.removeFromCart(event.productId)
                loadCartItems()
            }
        }
    }
}