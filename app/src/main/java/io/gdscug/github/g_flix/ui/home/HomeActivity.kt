package io.gdscug.github.g_flix.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.gdscug.github.g_flix.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}