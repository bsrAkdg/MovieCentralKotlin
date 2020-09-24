package com.bsrakdg.moviecentral.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "popularity")
    var popularity: Double,

    @ColumnInfo(name = "vote_count")
    var vote_count: Int,

    @ColumnInfo(name = "vote_average")
    var vote_average: Double,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "release_date")
    var release_date: String,

    @ColumnInfo(name = "poster_path")
    var poster_path: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "genres")
    var genres: List<GenreCacheEntity>?
)