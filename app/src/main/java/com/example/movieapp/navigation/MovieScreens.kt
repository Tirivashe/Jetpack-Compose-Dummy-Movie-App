package com.example.movieapp.navigation

sealed class MovieScreens(val name: String){
    object HomeScreen: MovieScreens("Home")
    object DetailScreen: MovieScreens("Details")
}