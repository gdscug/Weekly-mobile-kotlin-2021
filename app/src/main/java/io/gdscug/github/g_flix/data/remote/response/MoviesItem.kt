package io.gdscug.github.g_flix.data.remote.response

import com.google.gson.annotations.SerializedName

data class MoviesItem(

    @field:SerializedName("num_review")
    val numReview: String,

    @field:SerializedName("age_rating")
    val ageRating: String,

    @field:SerializedName("year")
    val year: Int,

    @field:SerializedName("director")
    val director: List<String>,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("poster_url")
    val posterUrl: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("movie_id")
    val movieId: String,

    @field:SerializedName("movie_title")
    val movieTitle: String,

    @field:SerializedName("movie_url")
    val movieUrl: String,

    @field:SerializedName("cast")
    val cast: List<String>,

    @field:SerializedName("casts")
    val casts: List<Any>,

    @field:SerializedName("movie_length")
    val movieLength: String,

    @field:SerializedName("genre")
    val genre: List<String>,

    @field:SerializedName("movie_genres")
    val movieGenres: List<Int>,

    @field:SerializedName("_id")
    val id: String,

    @field:SerializedName("writer")
    val writer: List<String>
)
