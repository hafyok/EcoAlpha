package com.example.ecoalpha.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecoalpha.presentation.DetailScreen.DetailScreen
import com.example.ecoalpha.presentation.HomeScreen.HomeScreen


@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "home_screen"){
        composable("home_screen"){
            HomeScreen()
        }
        composable("detail_screen"){
            DetailScreen()
        }
    }
}