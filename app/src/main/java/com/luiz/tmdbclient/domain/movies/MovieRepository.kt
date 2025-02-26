package com.luiz.tmdbclient.domain.movies

import com.luiz.tmdbclient.data.model.movies.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies():List<Movie>?

}