package com.luiz.tmdbclient.domain.artist

import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.data.model.tvshows.TvShow

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.updateArtist()

}