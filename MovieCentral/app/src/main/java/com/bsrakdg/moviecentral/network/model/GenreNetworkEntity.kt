package com.bsrakdg.moviecentral.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GenreNetworkEntity(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String
) {

    // for equals test, this is important (it isn't necessary for data class )
    override fun equals(other: Any?): Boolean {
        return if (other is GenreNetworkEntity) other.id == id && other.name == name else false
    }
}