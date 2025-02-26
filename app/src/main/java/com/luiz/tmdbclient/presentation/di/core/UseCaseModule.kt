package com.luiz.tmdbclient.presentation.di.core

import com.luiz.tmdbclient.domain.artist.ArtistRepository
import com.luiz.tmdbclient.domain.artist.GetArtistUseCase
import com.luiz.tmdbclient.domain.artist.UpdateArtistUseCase
import com.luiz.tmdbclient.domain.movies.GetMoviesUseCase
import com.luiz.tmdbclient.domain.movies.MovieRepository
import com.luiz.tmdbclient.domain.movies.UpdateMoviesUseCase
import com.luiz.tmdbclient.domain.tvShows.GetTvShowsUseCase
import com.luiz.tmdbclient.domain.tvShows.TvShowRepository
import com.luiz.tmdbclient.domain.tvShows.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvshowUseCase(tvshowRepository: TvShowRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvshowRepository)
    }
    @Provides
    fun provideUpdateTvshowUseCase(tvshowRepository: TvShowRepository):UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvshowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }

}