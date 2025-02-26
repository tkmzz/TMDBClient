package com.luiz.tmdbclient.data.repository.tvshow

import android.util.Log
import com.luiz.tmdbclient.data.model.tvshows.TvShow
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowCacheDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowLocalDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowRemoteDatasource
import com.luiz.tmdbclient.domain.tvShows.TvShowRepository

class TvshowRepositoryImpl(
    private val tvshowRemoteDatasource: TvshowRemoteDatasource,
    private val tvshowLocalDatasource: TvshowLocalDatasource,
    private val tvshowCacheDatasource: TvshowCacheDatasource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvshows = getTvshowsFromAPI()
        tvshowLocalDatasource.clearAll()
        tvshowLocalDatasource.saveTvshowsToDB(newListOfTvshows)
        tvshowCacheDatasource.saveTvshowsToCache(newListOfTvshows)
        return newListOfTvshows
    }

    suspend fun getTvshowsFromAPI(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>

        try {
            val response = tvshowRemoteDatasource.getTvshows()
            val body = response.body()
            if (body != null) {
                tvshowList = body.tvshows
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return tvshowList
    }

    suspend fun getTvshowsFromDB(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>

        try {
            tvshowList = tvshowLocalDatasource.getTvshowsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvshowList.isNotEmpty()) {
            return tvshowList
        } else {
            tvshowList = getTvshowsFromAPI()
            tvshowLocalDatasource.saveTvshowsToDB(tvshowList)
        }
        return tvshowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>

        try {
            tvshowList = tvshowCacheDatasource.getTvshowsFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvshowList.isNotEmpty()) {
            return tvshowList
        } else {
            tvshowList = getTvshowsFromDB()
            tvshowCacheDatasource.saveTvshowsToCache(tvshowList)
        }
        return tvshowList
    }
}