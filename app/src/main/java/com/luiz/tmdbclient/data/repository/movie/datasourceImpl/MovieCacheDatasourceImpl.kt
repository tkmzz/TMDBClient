package com.luiz.tmdbclient.data.repository.movie.datasourceImpl

import com.luiz.tmdbclient.data.model.movies.Movie
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl : MovieCacheDatasource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}