package com.luiz.tmdbclient.presentation.artist


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luiz.tmdbclient.domain.artist.GetArtistUseCase
import com.luiz.tmdbclient.domain.artist.UpdateArtistUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updateArtistUseCase) as T
    }
}