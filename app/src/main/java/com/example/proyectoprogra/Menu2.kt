package com.example.proyectoprogra

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Menu2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu2) // Carga el layout 'menu2.xml'

        // --- Asigna el listener a la tarjeta de Planetas ---
        val cardPlanetas = findViewById<CardView>(R.id.card_planetas)

        cardPlanetas.setOnClickListener {
            // Inicia la Activity 'Planetas'
            val intent = Intent(this, Planetas::class.java)
            startActivity(intent)
        }

        // --- Asigna el listener a la tarjeta de Galaxias ---
        val cardGalaxias = findViewById<CardView>(R.id.card_galaxias)

        cardGalaxias.setOnClickListener {
            // (Aún no tienes esta pantalla, pero así sería)
            // val intent = Intent(this, GalaxiasActivity::class.java)
            // startActivity(intent)
        }

        // ... Repite para las otras 4 tarjetas ...
    }
}