package com.example.proyectoprogra

import android.content.Context
import android.media.MediaPlayer

object MusicManager {
    private var mediaPlayer: MediaPlayer? = null
    private var isMusicStarted = false

    fun startMusic(context: Context) {
        if (!isMusicStarted) {
            mediaPlayer = MediaPlayer.create(context, R.raw.musica_fondo)
            mediaPlayer?.isLooping = true
            mediaPlayer?.start()
            isMusicStarted = true
        }
    }

    fun pauseMusic() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        }
    }

    fun resumeMusic() {
        if (isMusicStarted && mediaPlayer?.isPlaying == false) {
            mediaPlayer?.start()
        }
    }

    fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        isMusicStarted = false
    }
}