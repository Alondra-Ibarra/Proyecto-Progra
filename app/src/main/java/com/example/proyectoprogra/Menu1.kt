package com.example.proyectoprogra

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.media.MediaPlayer

class Menu1 : AppCompatActivity() {

    private var isChangingActivity = false // 1. Variable de control para la música

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        // Configuración del botón "Explorar el Universo"
        val botonExplorar = findViewById<ImageView>(R.id.btn_explore_universe)
        botonExplorar.setOnClickListener {
            isChangingActivity = true // Marcamos que cambiamos de actividad

            val intent = Intent(this, Menu2::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Configuración del botón "Teorías"
        val botonTeorias = findViewById<ImageView>(R.id.btn_theories)
        botonTeorias.setOnClickListener {
            isChangingActivity = true // Marcamos que cambiamos de actividad

            val intent = Intent(this, Teorias::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        val botonJuego = findViewById<ImageView>(R.id.btn_practice_quiz)

        botonJuego.setOnClickListener {
            val intent = Intent(this, Niveles::class.java)
            startActivity(intent)

            // Agrega transición de desvanecimiento
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Puedes agregar los listeners para tus otros botones aquí
        // val cardQuiz = findViewById<ImageView>(R.id.btn_practice_quiz)
        // cardQuiz.setOnClickListener {
        //    isChangingActivity = true
        //    val intent = Intent(this, QuizActivity::class.java)
        //    startActivity(intent)
        //    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        // }
    }

    override fun onResume() {
        super.onResume()
        MusicManager.resumeMusic()
        isChangingActivity = false // Resetear al volver a esta pantalla
    }

    override fun onPause() {
        super.onPause()
        // 3. Lógica de pausa inteligente: Solo pausar si NO estamos cambiando de actividad
        if (!isChangingActivity) {
            MusicManager.pauseMusic()
        }
    }
}