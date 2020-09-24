package com.bsrakdg.moviecentral.model

data class Movie(
    var id: Int,
    var popularity: Double,
    var vote_count: Int,
    var vote_average: Double,
    var title: String,
    var release_date: String,
    var poster_path: String,
    var overview: String,
    var genres: List<Genre>?
)