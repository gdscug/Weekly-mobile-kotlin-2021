package io.gdscug.github.g_flix.data.remote

import io.gdscug.github.g_flix.api.ApiConfig
import io.gdscug.github.g_flix.data.remote.response.MovieResponse
import io.gdscug.github.g_flix.data.remote.response.RecommendationResponse
import retrofit2.Call

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource()
        }
    }

    // fetch data from API for AllMovies
    fun getAllMovies(): Call<MovieResponse> = ApiConfig.getApiService().getAllMovies()

    // fetch data from API for Movie Recomendation
    fun getMovieRecomendation(id: String): Call<RecommendationResponse> =
        ApiConfig.getApiService().getRecomendation(id)
}