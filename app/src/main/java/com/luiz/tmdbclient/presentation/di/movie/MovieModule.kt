package com.luiz.tmdbclient.presentation.di.movie

import com.luiz.tmdbclient.domain.movies.GetMoviesUseCase
import com.luiz.tmdbclient.domain.movies.UpdateMoviesUseCase
import com.luiz.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }

}