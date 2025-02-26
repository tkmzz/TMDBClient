package com.luiz.tmdbclient.domain.artist

import com.luiz.tmdbclient.data.model.artist.Artist


interface ArtistRepository {

    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist():List<Artist>?

}