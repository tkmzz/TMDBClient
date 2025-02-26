package com.luiz.tmdbclient.data.repository.movie.datasource

import com.luiz.tmdbclient.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}