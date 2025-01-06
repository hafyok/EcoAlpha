package com.example.ecoalpha.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,

) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        NavGraph(navHostController = navController)
    }
}