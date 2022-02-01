package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.utils.getMovies
import com.example.movieapp.widgets.MovieCard

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = { HomeTopAppBar() }
    ) {
        HomeMainContent(navController)
    }
}

@Composable
private fun HomeTopAppBar() {
    TopAppBar(
        backgroundColor = Color.Cyan,
        elevation = 5.dp
    ) {
        Text(text = "Movies")
    }
}

@Composable
fun HomeMainContent(navController: NavController){
    val movies = getMovies()
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(movies){ movie ->
                MovieCard(movie = movie){ movieId ->
                    navController.navigate(route = MovieScreens.DetailScreen.name+"/$movieId")
                }
            }
        }
    }
}

