package com.luiz.tmdbclient.data.repository.tvshow.datasourceImpl

import com.luiz.tmdbclient.data.db.dao.TvShowDao
import com.luiz.tmdbclient.data.model.tvshows.TvShow
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvshowLocalDatasourceImpl(private val tvshowDao: TvShowDao) : TvshowLocalDatasource {

    override suspend fun getTvshowsFromDB(): List<TvShow> {
        return tvshowDao.getTvShows()
    }

    override suspend fun saveTvshowsToDB(tvshows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.saveTvShows(tvshows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.deleteAllTvShows()
        }
    }
}