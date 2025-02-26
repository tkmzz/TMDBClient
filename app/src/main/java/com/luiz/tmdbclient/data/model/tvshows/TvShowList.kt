package com.luiz.tmdbclient.data.model.tvshows


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvshows: List<TvShow>
)