package com.luiz.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.luiz.tmdbclient.data.db.dao.MovieDao
import com.luiz.tmdbclient.data.model.movies.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "date1", "title1"),
            Movie(2, "overview2", "posterPath2", "date2", "title2"),
            Movie(3, "overview3", "posterPath3", "date3", "title3"),
            Movie(4, "overview4", "posterPath4", "date4", "title4")
        )
        dao.saveMovies(movies)

        val allMovies = dao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "date1", "title1"),
            Movie(2, "overview2", "posterPath2", "date2", "title2"),
            Movie(3, "overview3", "posterPath3", "date3", "title3"),
            Movie(4, "overview4", "posterPath4", "date4", "title4")
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesResult = dao.getMovies()
        Truth.assertThat(moviesResult).isEmpty()
    }
}