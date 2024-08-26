package com.bethwel.movieapp

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MovieRepository

    init {
        val movieDao = MovieDatabase.getDatabase(application).movieDao()
        repository = MovieRepository(movieDao)
    }

    val allMovies: LiveData<List<Movie>> = repository.getAllMovies().asLiveData()

    fun searchMovies(query: String): LiveData<List<Movie>> {
        return repository.searchMovies("%$query%").asLiveData()
    }

    fun insertMovie(movie: Movie) = viewModelScope.launch {
        repository.insertMovie(movie)
    }
}
