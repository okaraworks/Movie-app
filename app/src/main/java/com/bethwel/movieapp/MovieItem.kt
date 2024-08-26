package com.bethwel.movieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun MovieItem(movie: Movie) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberImagePainter(movie.imageUrl),
            contentDescription = movie.title,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = movie.title, style = MaterialTheme.typography.h6)
            Text(text = movie.description, style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun MovieList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie = movie)
        }
    }
}

