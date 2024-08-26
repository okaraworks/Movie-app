package com.bethwel.movieapp

import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {
    fun searchMovies(query: String): Flow<List<Movie>> = movieDao.searchMovies(query)
    suspend fun insertMovie(movie: Movie) = movieDao.insertMovie(movie)
    fun getAllMovies(): Flow<List<Movie>> = movieDao.getAllMovies()
}
