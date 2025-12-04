package com.example.proyectoprogra

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView // Importante: ¡Esta es la clase correcta!
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView // (Esta ya no es necesaria para esta variable, pero la dejamos por si la usan los otros botones)

class Menu1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val botonExplorar = findViewById<ImageView>(R.id.btn_explore_universe)

        botonExplorar.setOnClickListener {
            val intent = Intent(this, Menu2::class.java)
            startActivity(intent)

            // Agrega transición de desvanecimiento
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }


        val botonTeorias = findViewById<ImageView>(R.id.btn_theories)

        botonTeorias.setOnClickListener {
            val intent = Intent(this, Teorias::class.java)
            startActivity(intent)

            // Agrega transición de desvanecimiento
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
        // val cardQuiz = findViewById<CardView>(R.id.btn_practice_quiz)
        // cardQuiz.setOnClickListener {
        //    // val intent = Intent(this, QuizActivity::class.java)
        //    // startActivity(intent)
        // }
    }
}

