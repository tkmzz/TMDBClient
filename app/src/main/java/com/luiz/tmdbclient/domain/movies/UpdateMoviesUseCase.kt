package com.luiz.tmdbclient.domain.movies

import com.luiz.tmdbclient.data.model.movies.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updateMovies()

}