package io.gdscug.github.g_flix.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.gdscug.github.g_flix.data.local.entity.MovieEntity
import io.gdscug.github.g_flix.data.remote.RemoteDataSource
import io.gdscug.github.g_flix.data.remote.response.MovieResponse
import io.gdscug.github.g_flix.data.remote.response.RecommendationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GFlixRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    GFlixDataSource {

    companion object {
        @Volatile
        private var instance: GFlixRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): GFlixRepository =
            instance ?: synchronized(this) {
                instance ?: GFlixRepository(remoteDataSource)
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movies = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { callback ->
                        val movieList = arrayListOf<MovieEntity>()
                        for (result in callback.movies) {
                            movieList.add(
                                MovieEntity(
                                    result.movieId,
                                    result.movieTitle,
                                    result.posterUrl,
                                    result.description
                                )
                            )
                        }
                        movies.postValue(movieList)
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return movies
    }

    override fun getMovieRecomendation(id: String): LiveData<List<MovieEntity>> {
        val moviesRecomendation = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getMovieRecomendation(id)
            .enqueue(object : Callback<RecommendationResponse> {
                override fun onResponse(
                    call: Call<RecommendationResponse>,
                    response: Response<RecommendationResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback ->
                            val movieList = arrayListOf<MovieEntity>()
                            for (result in callback.recommendations!!) {
                                movieList.add(
                                    MovieEntity(
                                        result?.movieId,
                                        result?.movieTitle,
                                        result?.posterUrl,
                                        result?.description
                                    )
                                )
                            }
                            moviesRecomendation.postValue(movieList)
                        }
                    }
                }

                override fun onFailure(call: Call<RecommendationResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        return moviesRecomendation
    }
}