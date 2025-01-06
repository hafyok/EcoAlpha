package com.example.ecoalpha.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


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