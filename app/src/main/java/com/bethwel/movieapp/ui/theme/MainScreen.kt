package com.bethwel.movieapp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.bethwel.movieapp.AddMovieScreen
import com.bethwel.movieapp.MovieViewModel
import com.bethwel.movieapp.SearchMovieScreen

@Composable
fun MainScreen(viewModel: MovieViewModel) {
    var currentScreen by remember { mutableStateOf("search") }

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = currentScreen == "search",
                    onClick = { currentScreen = "search" },
                    label = { Text("Search") },
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") }
                )
                BottomNavigationItem(
                    selected = currentScreen == "add",
                    onClick = { currentScreen = "add" },
                    label = { Text("Add") },
                    icon = { Icon(Icons.Default.Add, contentDescription = "Add") }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentScreen) {
                "search" -> SearchMovieScreen(viewModel = viewModel)
                "add" -> AddMovieScreen(viewModel = viewModel)
            }
        }
    }
}
