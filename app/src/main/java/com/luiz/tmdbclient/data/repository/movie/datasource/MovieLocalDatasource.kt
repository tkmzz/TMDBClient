package com.luiz.tmdbclient.data.repository.movie.datasource

import com.luiz.tmdbclient.data.model.movies.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}