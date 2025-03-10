package com.luiz.tmdbclient.data.api

import com.luiz.tmdbclient.data.model.artist.ArtistList
import com.luiz.tmdbclient.data.model.movies.MovieList
import com.luiz.tmdbclient.data.model.tvshows.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<ArtistList>

}