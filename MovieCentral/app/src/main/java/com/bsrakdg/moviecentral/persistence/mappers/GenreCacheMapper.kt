package com.bsrakdg.moviecentral.persistence.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.persistence.model.GenreCacheEntity
import com.bsrakdg.moviecentral.util.EntityMapper
import javax.inject.Inject

class GenreCacheMapper
@Inject
constructor() : EntityMapper<GenreCacheEntity, Genre> {

    override fun mapFromEntity(entityModel: GenreCacheEntity) = Genre(
        id = entityModel.id,
        name = entityModel.name
    )

    override fun mapToEntity(domainModel: Genre) = GenreCacheEntity(
        id = domainModel.id,
        name = domainModel.name
    )
}