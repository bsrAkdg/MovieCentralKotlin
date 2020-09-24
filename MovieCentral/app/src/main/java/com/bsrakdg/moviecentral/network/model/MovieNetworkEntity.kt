package com.bsrakdg.moviecentral.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieNetworkEntity(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("popularity")
    @Expose
    var popularity: Double,

    @SerializedName("vote_count")
    @Expose
    var vote_count: Int,

    @SerializedName("vote_average")
    @Expose
    var vote_average: Double,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("release_date")
    @Expose
    var release_date: String,

    @SerializedName("poster_path")
    @Expose
    var poster_path: String,

    @SerializedName("overview")
    @Expose
    var overview: String,

    @SerializedName("genres")
    @Expose
    var genres: List<GenreNetworkEntity>?
) {
    override fun equals(other: Any?): Boolean {
        return if (other is MovieNetworkEntity) other.id == id && other.title == title else false
    }
}