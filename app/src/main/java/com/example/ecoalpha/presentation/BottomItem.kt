package com.example.ecoalpha.presentation

import com.example.ecoalpha.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object HomeScreen: BottomItem("Medicament Screen", R.drawable.ic_launcher_foreground, "home_screen")
    object DetailScreen: BottomItem("Statistics Screen", R.drawable.ic_launcher_foreground, "detail_screen")
}