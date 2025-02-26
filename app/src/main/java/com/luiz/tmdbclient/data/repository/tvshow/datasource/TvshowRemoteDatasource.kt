package com.luiz.tmdbclient.data.repository.tvshow.datasource

import com.luiz.tmdbclient.data.model.tvshows.TvShowList
import retrofit2.Response

interface TvshowRemoteDatasource {
    suspend fun getTvshows(): Response<TvShowList>
}