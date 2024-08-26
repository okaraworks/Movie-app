package com.bethwel.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.bethwel.movieapp.ui.theme.MainScreen

import com.bethwel.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
