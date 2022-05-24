package io.gdscug.github.g_flix.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.gdscug.github.g_flix.R
import io.gdscug.github.g_flix.data.local.entity.MovieEntity
import io.gdscug.github.g_flix.databinding.ActivityDetailBinding
import io.gdscug.github.g_flix.databinding.ContentDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var contentBinding: ContentDetailBinding

    private var data: MovieEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        contentBinding = binding.contentDetail

        val movie = intent.extras
        if (movie != null) {
            data = intent.getParcelableExtra(EXTRA_MOVIE)
            data?.let { populatedMovie(it) }
        }
    }

    private fun populatedMovie(movieEntity: MovieEntity) {
        supportActionBar?.title = movieEntity.movieTitle

        contentBinding.tvRateAge.text = resources.getString(R.string.age_rate)
        contentBinding.tvGenre.text = resources.getString(R.string.genre)
        contentBinding.tvRate.text = resources.getString(R.string.rate)
        contentBinding.tvDesc.text = movieEntity.movieDescription

        Glide.with(this)
            .load(movieEntity.moviePoster)
            .into(binding.ivDetailImg)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}