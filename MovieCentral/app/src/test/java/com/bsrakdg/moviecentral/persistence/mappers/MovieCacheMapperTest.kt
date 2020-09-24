package com.bsrakdg.moviecentral.persistence.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.model.Movie
import com.bsrakdg.moviecentral.persistence.model.GenreCacheEntity
import com.bsrakdg.moviecentral.persistence.model.MovieCacheEntity
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class MovieCacheMapperTest {

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

    private val movieCacheEntity = MovieCacheEntity(
        1,
        5.0,
        5,
        3.0,
        "Inception",
        "12/12/2012",
        "inceptionPath",
        "Inception overview",
        listOf(GenreCacheEntity(1, "science fiction"))
    )

    private val movieCacheMapper = MovieCacheMapper()

    @Test
    fun mapFromEntity_isTitleEqual_success() {
        val mappingMovie = movieCacheMapper.mapFromEntity(movieCacheEntity)
        assertThat(mappingMovie.title, equalTo(movieCacheEntity.title))
    }

    @Test
    fun mapToEntity_isTitleEqual_success() {
        val mappingCacheMovie = movieCacheMapper.mapToEntity(movie)
        assertThat(mappingCacheMovie.title, equalTo(movie.title))
    }

    @Test
    fun fromGenresCacheEntity_genresIsNull() {
        movieCacheEntity.genres = null
        assertThat(
            movieCacheMapper.fromGenresCacheEntity(movieCacheEntity.genres),
            equalTo(null)
        )
    }

    @Test
    fun fromGenresCacheEntity_genresIsNotNull() {
        assertThat(
            movieCacheMapper.fromGenresCacheEntity(movieCacheEntity.genres),
            equalTo(listOf(Genre(1, "science fiction")))
        )
    }

    @Test
    fun toGenresCacheEntity_genresIsNull() {
        movie.genres = null
        assertThat(
            movieCacheMapper.toGenresCacheEntity(movie.genres),
            equalTo(null)
        )
    }

    @Test
    fun toGenresCacheEntity_genresIsNotNull() {
        assertThat(
            movieCacheMapper.toGenresCacheEntity(movie.genres),
            equalTo(listOf(GenreCacheEntity(1, "science fiction")))
        )
    }
}