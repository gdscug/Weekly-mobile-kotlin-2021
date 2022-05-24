package io.gdscug.github.g_flix.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.gdscug.github.g_flix.data.GFlixRepository
import io.gdscug.github.g_flix.di.Injection
import io.gdscug.github.g_flix.ui.home.HomeViewModel

class ViewModelFactory(private val gFlixRepository: GFlixRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideRepository())
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(gFlixRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass)
        }
    }
}