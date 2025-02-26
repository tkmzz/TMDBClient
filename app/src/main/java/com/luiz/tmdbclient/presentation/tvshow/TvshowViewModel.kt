package com.luiz.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.luiz.tmdbclient.domain.tvShows.GetTvShowsUseCase
import com.luiz.tmdbclient.domain.tvShows.UpdateTvShowsUseCase

class TvshowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModel() {

    fun getTvshows() = liveData {
        val tvShowsList = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvshows() = liveData {
        val tvShowsList = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}