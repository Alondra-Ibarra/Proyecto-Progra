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
            val intent = Intent(this, Galaxias::class.java)
            startActivity(intent)
        }

        //Asignaremos el listener de las tarjetas de Agujeros Negros
        val cardAgujeros = findViewById<CardView>(R.id.card_agujeros)
        cardAgujeros.setOnClickListener {
            // Inicia la actividad de agujeros negros
            val intent = Intent(this, AgujerosNegros::class.java)
            startActivity(intent)
        }

        //Asignaremos el lostener de las tarjetas de Constelaciones
        val cardConstelaciones = findViewById<CardView>(R.id.card_constelaciones)
        cardConstelaciones.setOnClickListener {
            // Inicia la actividad de constelaciones
            val intent = Intent(this, Constelaciones::class.java)
            startActivity(intent)
        }

        val cardNebulosas = findViewById<CardView>(R.id.card_nebulosas)
        cardNebulosas.setOnClickListener {
            // Inicia la actividad de constelaciones
            val intent = Intent(this, Nebulosas::class.java)
            startActivity(intent)
        }

        val cardEstrellas= findViewById<CardView>(R.id.card_estrellas)
        cardEstrellas.setOnClickListener {
            // Inicia la actividad de constelaciones
            val intent = Intent(this, Estrellas::class.java)
            startActivity(intent)
        }
    }
}