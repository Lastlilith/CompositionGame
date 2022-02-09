package com.example.compositiongame.presentation.activities

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.compositiongame.R

class MainActivity : AppCompatActivity() {

    private lateinit var backgroundMusic: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backgroundMusic = MediaPlayer.create(this, R.raw.background)
        backgroundMusic.start()

        //Workaround for not working isLooping
        backgroundMusic.setOnCompletionListener {
            backgroundMusic.start()
        }
    }

    override fun onPause() {
        super.onPause()
        backgroundMusic.pause()
    }

    override fun onResume() {
        super.onResume()
        backgroundMusic.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        backgroundMusic.release()
    }
}