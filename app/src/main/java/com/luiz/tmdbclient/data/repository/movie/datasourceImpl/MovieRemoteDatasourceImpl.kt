package com.luiz.tmdbclient.data.repository.movie.datasourceImpl

import com.luiz.tmdbclient.data.api.TMDBService
import com.luiz.tmdbclient.data.model.movies.MovieList
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}