package com.luiz.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.luiz.tmdbclient.data.model.movies.Movie
import com.luiz.tmdbclient.data.repository.movie.FakeMovieRepository
import com.luiz.tmdbclient.domain.movies.GetMoviesUseCase
import com.luiz.tmdbclient.domain.movies.UpdateMoviesUseCase
import com.luiz.tmdbclient.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "posterPath1", "releaseDate1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "releaseDate2", "title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "posterPath3", "releaseDate3", "title3"))
        movies.add(Movie(4, "overview4", "posterPath4", "releaseDate4", "title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}