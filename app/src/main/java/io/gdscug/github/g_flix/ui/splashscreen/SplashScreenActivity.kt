package io.gdscug.github.g_flix.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewPropertyAnimator
import io.gdscug.github.g_flix.databinding.ActivitySplashScreenBinding
import io.gdscug.github.g_flix.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {
    private val time: Long = 1100
    private val alpha0 = 0f
    private val alpha1 = 1f
    private var propertyAnim: ViewPropertyAnimator? = null

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivSplash.alpha = alpha0
        propertyAnim = binding.ivSplash.animate().setDuration(time).alpha(alpha1).withEndAction {
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }

    override fun onDestroy() {
        propertyAnim?.cancel()
        super.onDestroy()
    }
}