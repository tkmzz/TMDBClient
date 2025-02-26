package com.luiz.tmdbclient.presentation.di.core

import com.luiz.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.luiz.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.luiz.tmdbclient.data.repository.tvshow.TvshowRepositoryImpl
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowCacheDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowLocalDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowRemoteDatasource
import com.luiz.tmdbclient.domain.artist.ArtistRepository
import com.luiz.tmdbclient.domain.movies.MovieRepository
import com.luiz.tmdbclient.domain.tvShows.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieCacheDatasource: MovieCacheDatasource,
        movieLocalDatasource: MovieLocalDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvshowRepository(
        tvshowRemoteDatasource: TvshowRemoteDatasource,
        tvshowCacheDatasource: TvshowCacheDatasource,
        tvshowLocalDatasource: TvshowLocalDatasource
    ): TvShowRepository {
        return TvshowRepositoryImpl(
            tvshowRemoteDatasource,
            tvshowLocalDatasource,
            tvshowCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistCacheDatasource: ArtistCacheDatasource,
        artistLocalDatasource: ArtistLocalDatasource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }

}