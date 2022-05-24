package io.gdscug.github.g_flix.data

import androidx.lifecycle.LiveData
import io.gdscug.github.g_flix.data.local.entity.MovieEntity

interface GFlixDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>
}