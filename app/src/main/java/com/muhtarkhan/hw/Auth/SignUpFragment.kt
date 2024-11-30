package com.muhtarkhan.hw.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muhtarkhan.hw.R

class SignUpFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val navController = findNavController()
        setContent {
            SignUpScreen  (
                navigateToSneaker = {navController.navigate(R.id.action_SignUpFragment_to_SneakerFragment)},
                onIcon = {navController.navigate((R.id.action_SignUpFragment_to_MainFragment))}
            )
        }
    }
}