package com.luiz.tmdbclient.presentation.di.core

import com.luiz.tmdbclient.data.api.TMDBService
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.luiz.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.luiz.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowRemoteDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasourceImpl.TvshowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDatasource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvshowRemoteDatasource(tmdbService: TMDBService): TvshowRemoteDatasource {
        return TvshowRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDatasource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

}