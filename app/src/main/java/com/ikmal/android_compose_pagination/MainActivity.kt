package com.ikmal.android_compose_pagination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ikmal.android_compose_pagination.home.presentation.homeScreen
import com.ikmal.android_compose_pagination.moviedetail.presentation.movieDetailScreen
import com.ikmal.android_compose_pagination.ui.theme.AndroidcomposepaginationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidcomposepaginationTheme {
                Scaffold { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        homeScreen(navController = navController)
                        movieDetailScreen(navController = navController)
                    }
                }
            }
        }
    }
}