package com.example.proyectoprogra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. ¡ESTA ES LA LÍNEA CLAVE!
        // Inicia la música de fondo apenas abre la app.
        // Como es un Singleton, si ya está sonando, no se reiniciará.
        MusicManager.startMusic(this)

        val startButton = findViewById<Button>(R.id.boton_iniciar)

        // Prepara el sonido del clic (asegúrate de tener sonido_click.mp3 en res/raw)
        val clickSound = MediaPlayer.create(this, R.raw.inicio_boton)

        startButton.setOnClickListener {
            // Reproduce el sonido del botón
            clickSound?.start()

            // Pequeña espera para que se escuche el clic antes de cambiar de pantalla
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, Menu1::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }, 300)
        }
    }

    // Si el usuario sale de la app y vuelve, reanudamos la música
    override fun onResume() {
        super.onResume()
        MusicManager.resumeMusic()
    }

    // Opcional: Pausar si la app se va a segundo plano
    override fun onPause() {
        super.onPause()
        MusicManager.pauseMusic()
    }
}