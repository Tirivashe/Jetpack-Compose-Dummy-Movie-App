package com.example.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movie: String?){
    Scaffold(
        topBar = { TopBarComposable(navController) }
    ) {
        movie?.let { movieData ->
            Text(text = movieData)
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