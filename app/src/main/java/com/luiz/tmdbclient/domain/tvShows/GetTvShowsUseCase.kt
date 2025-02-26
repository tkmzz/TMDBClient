package com.luiz.tmdbclient.domain.tvShows

import com.luiz.tmdbclient.data.model.tvshows.TvShow

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()

}