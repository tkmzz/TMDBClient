package com.luiz.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luiz.tmdbclient.domain.tvShows.GetTvShowsUseCase
import com.luiz.tmdbclient.domain.tvShows.UpdateTvShowsUseCase

class TvshowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvshowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}