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
)