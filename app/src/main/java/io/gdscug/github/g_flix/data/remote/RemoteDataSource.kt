package io.gdscug.github.g_flix.data.remote

import io.gdscug.github.g_flix.api.ApiConfig
import io.gdscug.github.g_flix.data.remote.response.MovieResponse
import retrofit2.Call

class RemoteDataSource {
    // fetch data from API for AllMovies
    fun getAllMovies(): Call<MovieResponse> = ApiConfig.getApiService().getAllMovies()
}