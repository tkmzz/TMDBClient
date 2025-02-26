package com.luiz.tmdbclient.presentation.di.core

import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.luiz.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.luiz.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvshowCacheDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasourceImpl.TvshowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDatasource(): MovieCacheDatasource {
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvshowCacheDatasource(): TvshowCacheDatasource {
        return TvshowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDatasource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }

}