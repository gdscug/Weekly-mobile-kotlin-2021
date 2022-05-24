package io.gdscug.github.g_flix.api

import io.gdscug.github.g_flix.data.remote.response.MovieResponse
import io.gdscug.github.g_flix.data.remote.response.RecommendationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("movies")
    fun getAllMovies(): Call<MovieResponse>

    @GET("recommendation/{id}")
    fun getRecomendation(
        @Path("id") id: String
    ): Call<RecommendationResponse>
}