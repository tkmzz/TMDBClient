package com.luiz.tmdbclient.presentation.di.core

import com.luiz.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.luiz.tmdbclient.presentation.di.movie.MovieSubComponent
import com.luiz.tmdbclient.presentation.di.tvshow.TvshowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvshowSubComponent():TvshowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory

}