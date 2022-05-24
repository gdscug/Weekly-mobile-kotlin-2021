package io.gdscug.github.g_flix.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.gdscug.github.g_flix.databinding.ActivityHomeBinding
import io.gdscug.github.g_flix.databinding.ContentHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var contentHomeBinding: ContentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contentHomeBinding = binding.contentHome
        setSupportActionBar(binding.toolbar)
    }
}