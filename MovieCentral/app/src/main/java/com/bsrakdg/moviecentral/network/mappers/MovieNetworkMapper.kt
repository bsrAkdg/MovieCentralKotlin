package com.bsrakdg.moviecentral.network.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.model.Movie
import com.bsrakdg.moviecentral.network.model.GenreNetworkEntity
import com.bsrakdg.moviecentral.network.model.MovieNetworkEntity
import com.bsrakdg.moviecentral.util.EntityMapper
import javax.inject.Inject

class MovieNetworkMapper
@Inject
constructor() : EntityMapper<MovieNetworkEntity, Movie> {

    override fun mapFromEntity(entityModel: MovieNetworkEntity) = Movie(
        id = entityModel.id,
        popularity = entityModel.popularity,
        vote_count = entityModel.vote_count,
        vote_average = entityModel.vote_average,
        title = entityModel.title,
        release_date = entityModel.release_date,
        poster_path = entityModel.poster_path,
        overview = entityModel.overview,
        genres = fromGenresNetworkEntity(entityModel.genres)
    )

    override fun mapToEntity(domainModel: Movie) = MovieNetworkEntity(
        id = domainModel.id,
        popularity = domainModel.popularity,
        vote_count = domainModel.vote_count,
        vote_average = domainModel.vote_average,
        title = domainModel.title,
        release_date = domainModel.release_date,
        poster_path = domainModel.poster_path,
        overview = domainModel.overview,
        genres = toGenresNetworkEntity(domainModel.genres)
    )

    fun fromGenresNetworkEntity(genres: List<GenreNetworkEntity>?): List<Genre>? {
        return genres?.let { genresNetworkList ->
            genresNetworkList.map { Genre(it.id, it.name) }
        }
    }

    fun toGenresNetworkEntity(genres: List<Genre>?): List<GenreNetworkEntity>? {
        return genres?.let { genreList ->
            genreList.map { GenreNetworkEntity(it.id, it.name) }
        }
    }
}