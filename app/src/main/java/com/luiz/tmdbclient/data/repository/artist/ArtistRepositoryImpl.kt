package com.luiz.tmdbclient.data.repository.artist

import android.util.Log
import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.luiz.tmdbclient.domain.artist.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist> {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist> {
        val newListOfArtists = getArtistFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}