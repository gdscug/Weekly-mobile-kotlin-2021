package io.gdscug.github.g_flix.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.gdscug.github.g_flix.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}