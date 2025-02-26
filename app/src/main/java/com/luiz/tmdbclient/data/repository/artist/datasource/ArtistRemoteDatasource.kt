package com.luiz.tmdbclient.data.repository.artist.datasource

import com.luiz.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}