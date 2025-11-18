package com.example.proyectoprogra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView


class Galaxias: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.galaxias)

        val cardViaLactea = findViewById<CardView>(R.id.card_viaLactea)
        val cardSombrero = findViewById<CardView>(R.id.card_sombrero)
        val cardCigarro = findViewById<CardView>(R.id.card_Cigarro)
        val card4696 = findViewById<CardView>(R.id.card_4696)
        val cardGirasol = findViewById<CardView>(R.id.card_Girasol)

        cardViaLactea.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.galaxia_viaLactea_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.galaxia_viaLactea_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.galaxia_vialactea)
            startActivity(intent)
        }

        cardSombrero.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.galaxia_sombrero_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.galaxia_sombrero_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.galaxia_sombrero)
            startActivity(intent)
        }

        cardCigarro.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.galaxia_cigarro_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.galaxia_cigarro_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.galaxia_cigarro)
            startActivity(intent)
        }

        card4696.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.galaxia_4696_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.galaxia_4696_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.galaxia_4696)
            startActivity(intent)
        }

        cardGirasol.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.galaxia_girsaol_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.galaxia_girsaol_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.galaxia_girsaol)
            startActivity(intent)
        }
    }

}