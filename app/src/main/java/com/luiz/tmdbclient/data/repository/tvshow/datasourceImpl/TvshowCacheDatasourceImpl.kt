package com.luiz.tmdbclient.data.repository.tvshow.datasourceImpl

import com.luiz.tmdbclient.data.model.tvshows.TvShow
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowCacheDatasource

class TvshowCacheDatasourceImpl : TvshowCacheDatasource {

    private var tvshowList = ArrayList<TvShow>()

    override suspend fun getTvshowsFromCache(): List<TvShow> {
        return tvshowList
    }

    override suspend fun saveTvshowsToCache(tvshows: List<TvShow>) {
        tvshowList.clear()
        tvshowList = ArrayList(tvshows)
    }
}