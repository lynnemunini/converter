package com.grayseal.mp3converter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grayseal.mp3converter.ui.main.DownloadScreen
import com.grayseal.mp3converter.ui.main.InitialScreen

@Composable
fun MP3ConverterNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MP3ConverterScreens.InitialScreen.name) {
        composable(MP3ConverterScreens.InitialScreen.name) {
            InitialScreen()
        }
        composable(MP3ConverterScreens.DownloadScreen.name) {
            DownloadScreen()
        }
    }
}