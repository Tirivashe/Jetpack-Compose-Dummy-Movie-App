package com.example.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieCard

@Composable
fun DetailsScreen(navController: NavController, movieId: String?){
    val movieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    
    val movie = movieList[0]

    Scaffold(
        topBar = { TopBarComposable(navController) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieCard(movie = movie)
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                ImageCarosel(movie)
            }
        }
    }
}

@Composable
private fun ImageCarosel(movie: Movie) {
    LazyRow {
        items(movie.images) { image ->
            Card(
                modifier = Modifier
                    .size(240.dp)
                    .padding(12.dp),
                elevation = 5.dp
            ) {
                Image(painter = rememberImagePainter(data = image), contentDescription = null)
            }
        }
    }
}

@Composable
fun TopBarComposable(navController: NavController){
    TopAppBar(
        backgroundColor = Color.LightGray,
        elevation = 3.dp
    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Go Back",
                modifier = Modifier
                    .clickable { navController.popBackStack() }
            )
        }
        Spacer(modifier = Modifier.width(80.dp))
        Text(text = "Movies")
    }
}