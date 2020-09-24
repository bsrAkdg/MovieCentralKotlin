package com.bsrakdg.moviecentral.persistence.mappers

import com.bsrakdg.moviecentral.model.Genre
import com.bsrakdg.moviecentral.model.Movie
import com.bsrakdg.moviecentral.persistence.model.GenreCacheEntity
import com.bsrakdg.moviecentral.persistence.model.MovieCacheEntity
import com.bsrakdg.moviecentral.util.EntityMapper
import javax.inject.Inject

class MovieCacheMapper
@Inject
constructor() : EntityMapper<MovieCacheEntity, Movie> {

    override fun mapFromEntity(entityModel: MovieCacheEntity) = Movie(
        id = entityModel.id,
        popularity = entityModel.popularity,
        vote_count = entityModel.vote_count,
        vote_average = entityModel.vote_average,
        title = entityModel.title,
        release_date = entityModel.release_date,
        poster_path = entityModel.poster_path,
        overview = entityModel.overview,
        genres = fromGenresCacheEntity(entityModel.genres)
    )

    override fun mapToEntity(domainModel: Movie) = MovieCacheEntity(
        id = domainModel.id,
        popularity = domainModel.popularity,
        vote_count = domainModel.vote_count,
        vote_average = domainModel.vote_average,
        title = domainModel.title,
        release_date = domainModel.release_date,
        poster_path = domainModel.poster_path,
        overview = domainModel.overview,
        genres = toGenresCacheEntity(domainModel.genres)
    )

    fun fromGenresCacheEntity(genreList: List<GenreCacheEntity>?): List<Genre>? {
        return genreList?.let { genres ->
            return genres.map { Genre(it.id, it.name) }
        }
    }

    fun toGenresCacheEntity(genreList: List<Genre>?): List<GenreCacheEntity>? {
        return genreList?.let { genres ->
            genres.map { GenreCacheEntity(it.id, it.name) }
        }
    }
}