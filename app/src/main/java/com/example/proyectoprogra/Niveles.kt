package com.example.proyectoprogra

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView // Importante para que no falle el cast
import java.io.File


class Niveles : AppCompatActivity() {

    private val nomArch = "record_max.txt" // Asegúrate que este nombre coincida con el que usas en juego1.kt (record_maximo.txt o record_max.txt)
    //iniciaremos musica
    private var mediaPlayer: MediaPlayer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.niveles) // Asegurate que tu XML se llame asi
        mediaPlayer = MediaPlayer.create(this, R.raw.niveles_sound)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
        mediaPlayer?.setVolume(0.5f, 0.5f)
    }

    override fun onResume() {
        super.onResume()
        actualizarNiv()
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null

    }

    private fun actualizarNiv() {
        val puntaje = ObtenerPuntaje()

        // Referencias a la UI
        val txtPuntaje = findViewById<TextView>(R.id.tvPuntaje)
        // OJO: Aquí cambié <Button> por <CardView> para evitar el crash
        val btnFacil = findViewById<CardView>(R.id.btnNivelFacil)
        val btnMedio = findViewById<CardView>(R.id.btnNivelMedio)
        val btnDificil = findViewById<CardView>(R.id.btnNivelDificil)

        txtPuntaje.text = "Puntaje: $puntaje"

        btnFacil.alpha = 1.0f
        btnFacil.setOnClickListener {
            jugar(1)
        }


        if (puntaje >= 600) { // Usamos Mayor o Igual, no solo Igual
            // Desbloqueado
            btnMedio.alpha = 1.0f
            btnMedio.setOnClickListener { jugar(2) }
        } else {
            // Bloqueado
            btnMedio.alpha = 0.4f
            btnMedio.setOnClickListener {
                Toast.makeText(this, "Necesitas 600 puntos para desbloquear", Toast.LENGTH_SHORT).show()
            }
        }


        if (puntaje >= 1600) {
            // Desbloqueado
            btnDificil.alpha = 1.0f
            btnDificil.setOnClickListener { jugar(3) }
        } else {
            // Bloqueado
            btnDificil.alpha = 0.4f
            btnDificil.setOnClickListener {
                Toast.makeText(this, "Necesitas 1600 puntos para desbloquear", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun jugar(dificultad: Int) {
        val intent = Intent(this, juego1::class.java)
        intent.putExtra("dificultad", dificultad)
        startActivity(intent)
    }

    private fun ObtenerPuntaje(): Int {
        val file = File(filesDir, nomArch)
        if (!file.exists()) return 0

        return try {
            val textoLeido = openFileInput(nomArch).bufferedReader().use { it.readText() }
            if (textoLeido.isNotEmpty()) textoLeido.toInt() else 0
        } catch (e: Exception) {
            0
        }
    }
}