package com.bsrakdg.moviecentral.network.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.model.Movie
import com.bsrakdg.moviecentral.network.model.GenreNetworkEntity
import com.bsrakdg.moviecentral.network.model.MovieNetworkEntity
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

class MovieNetworkMapperTest {

    private val movie = Movie(
        1,
        5.0,
        5,
        3.0,
        "Inception",
        "12/12/2012",
        "inceptionPath",
        "Inception overview",
        listOf(Genre(1, "science fiction"))
    )

    private val movieNetworkEntity = MovieNetworkEntity(
        1,
        5.0,
        5,
        3.0,
        "Inception",
        "12/12/2012",
        "inceptionPath",
        "Inception overview",
        listOf(GenreNetworkEntity(1, "science fiction"))
    )

    private val movieNetworkMapper = MovieNetworkMapper()

    @Test
    fun mapFromEntity_isTitleEqual_success() {
        val mappingMovie = movieNetworkMapper.mapFromEntity(movieNetworkEntity)
        assertThat(mappingMovie.title, equalTo(movieNetworkEntity.title))
    }

    @Test
    fun mapToEntity_isTitleEqual_success() {
        val mappingNetworkMovie = movieNetworkMapper.mapToEntity(movie)
        assertThat(mappingNetworkMovie.title, equalTo(movie.title))
    }

    @Test
    fun fromGenresNetworkEntity_genresIsNull() {
        movieNetworkEntity.genres = null
        assertThat(
            movieNetworkMapper.fromGenresNetworkEntity(movieNetworkEntity.genres),
            equalTo(null)
        )
    }

    @Test
    fun fromGenresNetworkEntity_genresIsNotNull() {
        assertThat(
            movieNetworkMapper.fromGenresNetworkEntity(movieNetworkEntity.genres),
            equalTo(listOf(Genre(1, "science fiction")))
        )
    }

    @Test
    fun toGenresNetworkEntity_genresIsNull() {
        movie.genres = null
        assertThat(
            movieNetworkMapper.toGenresNetworkEntity(movie.genres),
            equalTo(null)
        )
    }

    @Test
    fun toGenresNetworkEntity_genresIsNotNull() {
        assertThat(
            movieNetworkMapper.toGenresNetworkEntity(movie.genres),
            equalTo(listOf(GenreNetworkEntity(1, "science fiction")))
        )
    }
}