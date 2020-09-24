package com.bsrakdg.moviecentral.persistence.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.persistence.model.GenreCacheEntity
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class GenreCacheMapperTest {

    private val genre = Genre(
        id = 1,
        name = "science fiction"
    )

    private val genreCacheEntity = GenreCacheEntity(
        id = 1,
        name = "science fiction"
    )

    private val genreCacheMapper = GenreCacheMapper()

    @Test
    fun mapFromEntity_success() {
        assertThat(
            genreCacheMapper.mapFromEntity(genreCacheEntity),
            equalTo(genre)
        )
    }

    @Test
    fun mapToEntity_success() {
        assertThat(
            genreCacheMapper.mapToEntity(genre),
            equalTo(genreCacheEntity)
        )
    }
}