package com.bsrakdg.moviecentral.network.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.network.model.GenreNetworkEntity
import com.bsrakdg.moviecentral.util.EntityMapper
import javax.inject.Inject

class GenreNetworkMapper
@Inject
constructor() : EntityMapper<GenreNetworkEntity, Genre> {

    override fun mapFromEntity(entityModel: GenreNetworkEntity) = Genre(
        id = entityModel.id,
        name = entityModel.name
    )

    override fun mapToEntity(domainModel: Genre) = GenreNetworkEntity(
        id = domainModel.id,
        name = domainModel.name
    )
}