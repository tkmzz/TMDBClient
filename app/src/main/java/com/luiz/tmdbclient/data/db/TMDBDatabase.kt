package com.luiz.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luiz.tmdbclient.data.db.dao.ArtistDao
import com.luiz.tmdbclient.data.db.dao.MovieDao
import com.luiz.tmdbclient.data.db.dao.TvShowDao
import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.data.model.movies.Movie
import com.luiz.tmdbclient.data.model.tvshows.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}