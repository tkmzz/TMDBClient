package com.luiz.tmdbclient.presentation.di.tvshow

import com.luiz.tmdbclient.domain.tvShows.GetTvShowsUseCase
import com.luiz.tmdbclient.domain.tvShows.UpdateTvShowsUseCase
import com.luiz.tmdbclient.presentation.tvshow.TvshowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvshowModule {

    @TvshowScope
    @Provides
    fun provideTvshowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvshowViewModelFactory {
        return TvshowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}