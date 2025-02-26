package com.luiz.tmdbclient.presentation.di.artist

import com.luiz.tmdbclient.domain.artist.GetArtistUseCase
import com.luiz.tmdbclient.domain.artist.UpdateArtistUseCase
import com.luiz.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }

}