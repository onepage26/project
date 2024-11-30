package com.muhtarkhan.hw.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muhtarkhan.hw.R

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val navController = findNavController()
        setContent {

            WelcomeScreen(
                navigateToSignUp = { navController.navigate(R.id.action_MainFragment_to_SignUpFragment) },
                navigateToLogin = { navController.navigate(R.id.action_MainFragment_to_LogInFragment) }
            )

        }
    }
}