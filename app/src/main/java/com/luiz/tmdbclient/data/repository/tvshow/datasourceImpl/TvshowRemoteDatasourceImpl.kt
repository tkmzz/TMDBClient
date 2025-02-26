package com.luiz.tmdbclient.data.repository.tvshow.datasourceImpl

import com.luiz.tmdbclient.data.api.TMDBService
import com.luiz.tmdbclient.data.model.tvshows.TvShowList
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowRemoteDatasource
import retrofit2.Response

class TvshowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvshowRemoteDatasource {
    override suspend fun getTvshows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}