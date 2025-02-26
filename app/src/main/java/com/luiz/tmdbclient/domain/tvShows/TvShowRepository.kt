package com.luiz.tmdbclient.domain.tvShows

import com.luiz.tmdbclient.data.model.tvshows.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?

}