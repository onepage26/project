package com.muhtarkhan.hw.Main

import android.os.Bundle

import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import com.muhtarkhan.hw.R


class MainActivity : FragmentActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.setGraph(R.navigation.main_graph)
    }
}

