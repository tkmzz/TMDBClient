package com.luiz.tmdbclient.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luiz.tmdbclient.data.model.artist.Artist


@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtist(): List<Artist>

}