package com.grayseal.mp3converter.navigation

import com.grayseal.mp3converter.ui.main.InitialScreen

enum class MP3ConverterScreens {
    InitialScreen,
    DownloadScreen;

    companion object {
        fun fromRoute(route: String): MP3ConverterScreens = when (route.substringBefore("/")) {
            InitialScreen.name -> InitialScreen
            DownloadScreen.name -> DownloadScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}