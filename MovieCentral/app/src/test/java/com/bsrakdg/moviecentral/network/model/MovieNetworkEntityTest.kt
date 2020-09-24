package com.bsrakdg.moviecentral.network.model

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertThat
import org.junit.Test

class MovieNetworkEntityTest {

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

    private val movieNetworkEntitySame = MovieNetworkEntity(
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

    private val movieNetworkEntitySameName = MovieNetworkEntity(
        2,
        5.0,
        5,
        3.0,
        "Inception",
        "12/12/2012",
        "inceptionPath",
        "Inception overview",
        listOf(GenreNetworkEntity(1, "science fiction"))
    )

    private val movieNetworkEntityDifference = MovieNetworkEntity(
        2,
        5.0,
        5,
        3.0,
        "Forrest Gump",
        "10/10/2010",
        "forrestPath",
        "Forrest overview",
        listOf(GenreNetworkEntity(3, "biography"))
    )

    @Test
    fun testEquals_isEqualSame() {
        assertThat(movieNetworkEntity, equalTo(movieNetworkEntitySame))
    }

    @Test
    fun testEquals_notEqualWithSameName() {
        assertThat(movieNetworkEntity, not(equalTo(movieNetworkEntitySameName)))
    }

    @Test
    fun testEquals_notEqualDifferenceIdAndName() {
        assertThat(movieNetworkEntity, not(equalTo(movieNetworkEntityDifference)))
    }

    @Test
    fun getId_isEqualSuccess() {
        assertThat(movieNetworkEntity.id, equalTo(1))
    }

    @Test
    fun getPopularity_isEqualSuccess() {
        assertThat(movieNetworkEntity.popularity, equalTo(5.0))
    }

    @Test
    fun getVote_count_isEqualSuccess() {
        assertThat(movieNetworkEntity.vote_count, equalTo(5))
    }

    @Test
    fun getVote_average_isEqualSuccess() {
        assertThat(movieNetworkEntity.vote_average, equalTo(3.0))
    }

    @Test
    fun getTitle() {
        assertThat(movieNetworkEntity.title, equalTo("Inception"))
    }

    @Test
    fun getRelease_date() {
        assertThat(movieNetworkEntity.release_date, equalTo("12/12/2012"))
    }

    @Test
    fun getPoster_path() {
        assertThat(movieNetworkEntity.poster_path, equalTo("inceptionPath"))
    }

    @Test
    fun getOverview() {
        assertThat(movieNetworkEntity.overview, equalTo("Inception overview"))
    }

    @Test
    fun getGenres() {
        assertThat(
            movieNetworkEntity.genres,
            equalTo(listOf(GenreNetworkEntity(1, "science fiction")))
        )
    }
}