package com.muhtarkhan.hw.Cart

sealed interface CartEvent {
    data class AddToCart(val productId: Int) : CartEvent
    data class RemoveFromCart(val productId: Int) : CartEvent
}