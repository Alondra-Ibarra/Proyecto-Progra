package com.example.proyectoprogra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Estrellas: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.estrellas)

        val cardCapella = findViewById<CardView>(R.id.card_Capella)
        val cardPleyades = findViewById<CardView>(R.id.card_Pleyades)
        val cardOmega = findViewById<CardView>(R.id.card_Omega)
        val card3Marias = findViewById<CardView>(R.id.card_3Marias)
        val cardSol = findViewById<CardView>(R.id.card_Sol)

        cardCapella.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.estrella_capella_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.estrella_capella_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.estrella_capella)
            startActivity(intent)
        }

        cardPleyades.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.estrella_pleyades_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.estrella_pleyades_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.estrella_pleyades)
            startActivity(intent)
        }

        cardOmega.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.estrella_omega_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.estrella_omega_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.estrella_omega)
            startActivity(intent)
        }

        card3Marias.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.estrella_cinturiondeorion_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.estrella_cinturiondeorion_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.estrella_marias)
            startActivity(intent)
        }

        cardSol.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.estrella_sol_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.estrella_sol_descripcion)
            intent.putExtra("EXTRA_IMAGE", R.drawable.estrella_sol)
            startActivity(intent)
        }
    }
}