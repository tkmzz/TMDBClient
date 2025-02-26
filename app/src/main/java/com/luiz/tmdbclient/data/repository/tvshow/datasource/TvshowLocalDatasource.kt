package com.luiz.tmdbclient.data.repository.tvshow.datasource

import com.luiz.tmdbclient.data.model.tvshows.TvShow

interface TvshowLocalDatasource {
    suspend fun getTvshowsFromDB(): List<TvShow>
    suspend fun saveTvshowsToDB(tvshows:List<TvShow>)
    suspend fun clearAll()
}