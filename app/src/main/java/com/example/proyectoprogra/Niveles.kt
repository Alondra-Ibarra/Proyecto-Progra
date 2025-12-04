package com.example.proyectoprogra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView


class Niveles: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.niveles)

        val btnFacil = findViewById<CardView>(R.id.btnNivelFacil)
        val btnMedio = findViewById<CardView>(R.id.btnNivelMedio)
        val btnDificil = findViewById<CardView>(R.id.btnNivelDificil)

        btnFacil.setOnClickListener {
            val intent = Intent(this, juego1::class.java)
            intent.putExtra("dificultad", 1)
            startActivity(intent)
        }

        btnMedio.setOnClickListener {
            val intent = Intent(this, juego1::class.java)
            intent.putExtra("dificultad", 2)
            startActivity(intent)
        }

        btnDificil.setOnClickListener {
            val intent = Intent(this, juego1::class.java)
            intent.putExtra("dificultad", 3)
            startActivity(intent)
        }




    }
}