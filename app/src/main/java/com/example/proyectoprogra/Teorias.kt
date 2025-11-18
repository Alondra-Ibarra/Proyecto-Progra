package com.example.proyectoprogra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Teorias: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.teorias)

        val cardSeñal = findViewById<CardView>(R.id.card_Señal)
        val cardDisco = findViewById<CardView>(R.id.card_Disco)
        val cardCometa = findViewById<CardView>(R.id.card_Cometa)
        val cardPlanetasSim = findViewById<CardView>(R.id.card_PlanetasSim)
        val cardArea51 = findViewById<CardView>(R.id.card_Area51)

        cardSeñal.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.teoria_senal_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.teoria_senal_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.teoria_senal)
            startActivity(intent)
        }

        cardDisco.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.teoria_disco_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.teoria_disco_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.teoria_disco)
            startActivity(intent)
        }

        cardCometa.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.teoria_cometa_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.teoria_cometa_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.teoria_cometa)
            startActivity(intent)
        }

        cardPlanetasSim.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.teoria_planetas_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.teoria_planetas_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.teoria_planetas)
            startActivity(intent)
        }

        cardArea51.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.teoria_area_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.teoria_area_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.teoria_area)
            startActivity(intent)
        }
    }
}