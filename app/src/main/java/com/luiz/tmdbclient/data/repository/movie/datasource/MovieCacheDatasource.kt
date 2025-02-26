package com.luiz.tmdbclient.data.repository.movie.datasource

import com.luiz.tmdbclient.data.model.movies.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}