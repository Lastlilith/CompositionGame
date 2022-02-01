package com.example.compositiongame.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.compositiongame.R
import com.example.compositiongame.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashBinding: ActivitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        splashBinding.splashConstraint.animation = slideAnimation

        slideAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity((Intent(this@SplashActivity, MainActivity::class.java)))
                    finish()
                }, 1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
    }
}