package com.bsrakdg.moviecentral.network.model

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class GenreNetworkEntityTest {

    private val genreNetworkEntity = GenreNetworkEntity(
        id = 1,
        name = "science fiction"
    )

    private val genreNetworkEntitySame = GenreNetworkEntity(
        id = 1,
        name = "science fiction"
    )

    private val genreNetworkEntitySameName = GenreNetworkEntity(
        id = 2,
        name = "science fiction"
    )

    private val genreNetworkEntitySameId = GenreNetworkEntity(
        id = 1,
        name = "fantastic"
    )

    private val genreNetworkEntityDifference = GenreNetworkEntity(
        id = 2,
        name = "biography"
    )

    @Test
    fun testEquals_isEqualSameIdAndName() {
        assertThat(genreNetworkEntity == genreNetworkEntitySame, equalTo(true))
    }

    @Test
    fun testEquals_isEqualSameName() {
        assertThat(genreNetworkEntity == genreNetworkEntitySameName, equalTo(false))
    }

    @Test
    fun testEquals_isEqualSameId() {
        assertThat(genreNetworkEntity == genreNetworkEntitySameId, equalTo(false))
    }

    @Test
    fun testEquals_isEqualDifferenceIdAndName() {
        assertThat(genreNetworkEntity == genreNetworkEntityDifference, equalTo(false))
    }

    @Test
    fun getId() {
        assertThat(genreNetworkEntity.id, equalTo(1))
    }

    @Test
    fun getName() {
        assertThat(genreNetworkEntity.name, equalTo("science fiction"))
    }
}