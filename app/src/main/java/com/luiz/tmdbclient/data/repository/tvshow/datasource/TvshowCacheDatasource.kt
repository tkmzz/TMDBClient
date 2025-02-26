package com.luiz.tmdbclient.data.repository.tvshow.datasource

import com.luiz.tmdbclient.data.model.tvshows.TvShow

interface TvshowCacheDatasource {
    suspend fun getTvshowsFromCache(): List<TvShow>
    suspend fun saveTvshowsToCache(tvshows:List<TvShow>)
}