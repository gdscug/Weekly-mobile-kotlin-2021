package io.gdscug.github.g_flix.ui.home

import androidx.lifecycle.ViewModel
import io.gdscug.github.g_flix.data.local.entity.MovieEntity
import io.gdscug.github.g_flix.utils.dummy.MovieDummy

class HomeViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = MovieDummy.generateMovieDummy()
}