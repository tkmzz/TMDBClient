package com.luiz.tmdbclient.presentation.di

import com.luiz.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.luiz.tmdbclient.presentation.di.movie.MovieSubComponent
import com.luiz.tmdbclient.presentation.di.tvshow.TvshowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvshowSubComponent(): TvshowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}