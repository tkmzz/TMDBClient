package com.luiz.tmdbclient.presentation.di.tvshow

import com.luiz.tmdbclient.presentation.tvshow.TvshowActivity
import dagger.Subcomponent

@TvshowScope
@Subcomponent(modules = [TvshowModule::class])
interface TvshowSubComponent {
    fun inject(tvshowActivity: TvshowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvshowSubComponent
    }
}