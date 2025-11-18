package com.example.proyectoprogra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.cardview.widget.CardView

class AgujerosNegros: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.agujeros_negros)

        val cardTON618 = findViewById<CardView>(R.id.card_618)
        val cardM87 = findViewById<CardView>(R.id.card_M87)
        val cardSagitario = findViewById<CardView>(R.id.card_Sagitario)
        val cardUnicornio = findViewById<CardView>(R.id.card_Unicornio)
        val cardGaia = findViewById<CardView>(R.id.card_Gaia)

        cardTON618.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.agujero_ton618_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.agujero_ton618_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.agujero_ton618)
            startActivity(intent)
        }

        cardM87.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.agujero_m87_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.agujero_m87_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.agujero_m87)
            startActivity(intent)
        }

        cardSagitario.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.agujero_sagitario_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.agujero_sagitario_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.agujero_sagitario)
            startActivity(intent)
        }

        cardUnicornio.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.agujero_unicornio_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.agujero_unicornio_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.agujero_unicornio)
            startActivity(intent)
        }

        cardGaia.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.agujero_gaia_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.agujero_gaia_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.agujero_gaia)
            startActivity(intent)
        }
    }
}