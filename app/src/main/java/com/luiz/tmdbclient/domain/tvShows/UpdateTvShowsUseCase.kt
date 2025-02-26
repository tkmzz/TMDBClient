package com.luiz.tmdbclient.domain.tvShows

import com.luiz.tmdbclient.data.model.movies.Movie
import com.luiz.tmdbclient.data.model.tvshows.TvShow

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()

}