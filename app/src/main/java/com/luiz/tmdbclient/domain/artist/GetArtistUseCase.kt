package com.luiz.tmdbclient.domain.artist

import com.luiz.tmdbclient.data.model.artist.Artist

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.getArtist()

}