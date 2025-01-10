package com.example.ecoalpha.presentation.Navigation

import com.example.ecoalpha.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object HomeScreen: BottomItem("Home Screen", R.drawable.ic_android_black_24dp, "home_screen")
    object DetailScreen: BottomItem("Detail Screen", R.drawable.ic_android_black_24dp, "detail_screen")
}