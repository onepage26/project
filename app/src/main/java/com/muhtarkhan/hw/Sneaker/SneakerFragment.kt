package com.muhtarkhan.hw.Sneaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muhtarkhan.hw.Cart.CartViewModel
import com.muhtarkhan.hw.Cart.RoomCartProvider
import com.muhtarkhan.hw.Cart.models.CartViewModelFactory
import com.muhtarkhan.hw.R

class SneakerFragment: Fragment() {

    private val viewModel: CartViewModel by viewModels {
        CartViewModelFactory(RoomCartProvider(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val navController = findNavController()
        setContent {
            SneakerGrid(onCatalog = {navController.navigate(R.id.action_SneakerFragment_to_SneakerFragment)},
                onCart = {navController.navigate(R.id.action_SneakerFragment_to_CartFragment)},
                onProfile = {navController.navigate(R.id.action_SneakerFragment_to_ProfileFragment)},
                onEvent = viewModel::dispatch
            )
        }
    }
}