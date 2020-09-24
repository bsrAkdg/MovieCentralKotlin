package com.bsrakdg.moviecentral.network.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.network.model.GenreNetworkEntity
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class GenreNetworkMapperTest {

    private val genre = Genre(
        id = 1,
        name = "science fiction"
    )

    private val genreNetworkEntity = GenreNetworkEntity(
        id = 1,
        name = "science fiction"
    )

    private var genreNetworkMapper = GenreNetworkMapper()

    @Test
    fun mapFromEntity_isEqual_true() {
        assertThat(
            genreNetworkMapper.mapFromEntity(genreNetworkEntity).id,
            equalTo(genre.id)
        )
    }

    @Test
    fun mapToEntity_isEqual_true() {
        assertThat(
            genreNetworkMapper.mapToEntity(genre).id,
            equalTo(genreNetworkEntity.id)
        )
    }
}