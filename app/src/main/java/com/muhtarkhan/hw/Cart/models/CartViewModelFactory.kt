package com.muhtarkhan.hw.Cart.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhtarkhan.hw.Cart.CartViewModel
import com.muhtarkhan.hw.Cart.RoomCartProvider

class CartViewModelFactory(
    private val cartProvider: RoomCartProvider
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(cartProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}