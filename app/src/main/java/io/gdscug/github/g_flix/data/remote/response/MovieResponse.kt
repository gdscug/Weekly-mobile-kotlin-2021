package io.gdscug.github.g_flix.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("movies")
    val movies: List<MoviesItem>,

    @field:SerializedName("message")
    val message: String
)
