package com.ae.islami.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ae.islami.R
import com.ae.islami.home.HomeActivity
import com.ae.islami.databinding.ActivitySplashBinding
import java.io.BufferedReader
import java.io.InputStreamReader

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToSplash()
        }, 618)
    }

    private fun navigateToSplash() {
        binding.imgSplash.setImageResource(R.drawable.splash_bg)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHome()
        }, 1307)
    }

    private fun navigateToHome() {
        val intent = Intent(this@SplashActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}