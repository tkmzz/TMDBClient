package com.luiz.tmdbclient.presentation

import android.app.Application
import com.luiz.tmdbclient.BuildConfig
import com.luiz.tmdbclient.presentation.di.Injector
import com.luiz.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.luiz.tmdbclient.presentation.di.core.AppComponent
import com.luiz.tmdbclient.presentation.di.core.AppModule
import com.luiz.tmdbclient.presentation.di.core.DaggerAppComponent
import com.luiz.tmdbclient.presentation.di.core.NetModule
import com.luiz.tmdbclient.presentation.di.core.RemoteDataModule
import com.luiz.tmdbclient.presentation.di.movie.MovieSubComponent
import com.luiz.tmdbclient.presentation.di.tvshow.TvshowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvshowSubComponent(): TvshowSubComponent {
        return appComponent.tvshowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}