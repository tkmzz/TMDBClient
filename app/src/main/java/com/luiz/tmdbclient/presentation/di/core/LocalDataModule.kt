package com.luiz.tmdbclient.presentation.di.core

import com.luiz.tmdbclient.data.db.dao.ArtistDao
import com.luiz.tmdbclient.data.db.dao.MovieDao
import com.luiz.tmdbclient.data.db.dao.TvShowDao
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.luiz.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.luiz.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowLocalDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasourceImpl.TvshowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvshowLocalDataSource(tvShowDao: TvShowDao):TvshowLocalDatasource{
        return TvshowLocalDatasourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDao)
    }
}