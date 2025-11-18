package com.example.proyectoprogra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.content.Intent

class Constelaciones: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.constelaciones)

        val cardOrion = findViewById<CardView>(R.id.card_Orion)
        val cardOsa = findViewById<CardView>(R.id.card_Osa)
        val cardCasiopea = findViewById<CardView>(R.id.card_Casiopea)

        cardOrion.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.constelacion_orion_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.constelacion_orion_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.constelacion_orion)
            startActivity(intent)
        }

        cardOsa.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.constelacion_osa_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.constelacion_osa_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.constelacion_osa)
            startActivity(intent)
        }

        cardCasiopea.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.constelacion_casiopea_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.constelacion_casiopea_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.constelacion_casiopea)
            startActivity(intent)
        }

        val cardCruz = findViewById<CardView>(R.id.card_Cruz)
        cardCruz.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.constelacion_cruz_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.constelacion_cruz_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.constelacion_cruz)
            startActivity(intent)
        }

        val cardCisne = findViewById<CardView>(R.id.card_Cisne)
        cardCisne.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.constelacion_cisne_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.constelacion_cisne_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.constelacion_cisne)
            startActivity(intent)
        }
    }
}