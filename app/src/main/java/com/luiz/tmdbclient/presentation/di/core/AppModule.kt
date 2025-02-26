package com.luiz.tmdbclient.presentation.di.core

import android.content.Context
import com.luiz.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.luiz.tmdbclient.presentation.di.movie.MovieSubComponent
import com.luiz.tmdbclient.presentation.di.tvshow.TvshowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvshowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }

}