package com.luiz.tmdbclient.data.repository.artist.datasourceImpl

import com.luiz.tmdbclient.data.db.dao.ArtistDao
import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao) : ArtistLocalDatasource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}