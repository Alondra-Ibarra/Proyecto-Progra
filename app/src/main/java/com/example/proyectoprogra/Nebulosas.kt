package com.example.proyectoprogra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.content.Intent
class Nebulosas: AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.nebulosas)

         val cardOrion = findViewById<CardView>(R.id.card_Orion)
         cardOrion.setOnClickListener {
             val intent = Intent(this, DetallesPlanetas::class.java)
             intent.putExtra("EXTRA_TITLE", R.string.nebulosa_orion_titulo)
             intent.putExtra("EXTRA_DESCRIPTION", R.string.nebulosa_orion_desc)
             intent.putExtra("EXTRA_IMAGE", R.drawable.nebulosa_orion)
             startActivity(intent)
         }

         val cardPilares = findViewById<CardView>(R.id.card_Pilares)
         cardPilares.setOnClickListener {
             val intent = Intent(this, DetallesPlanetas::class.java)
             intent.putExtra("EXTRA_TITLE", R.string.nebulosa_pilares_titulo)
             intent.putExtra("EXTRA_DESCRIPTION", R.string.nebulosa_pilares_desc)
             intent.putExtra("EXTRA_IMAGE", R.drawable.nebulosa_pilares)
             startActivity(intent)
         }

         val cardCaballo = findViewById<CardView>(R.id.card_Caballo)
         cardCaballo.setOnClickListener {
             val intent = Intent(this, DetallesPlanetas::class.java)
             intent.putExtra("EXTRA_TITLE", R.string.nebulosa_caballo_titulo)
             intent.putExtra("EXTRA_DESCRIPTION", R.string.nebulosa_caballo_desc)
             intent.putExtra("EXTRA_IMAGE", R.drawable.nebulosa_caballo)
             startActivity(intent)
         }

         val cardOjo = findViewById<CardView>(R.id.card_Ojo)
         cardOjo.setOnClickListener {
             val intent = Intent(this, DetallesPlanetas::class.java)
             intent.putExtra("EXTRA_TITLE", R.string.nebulosa_ojo_titulo)
             intent.putExtra("EXTRA_DESCRIPTION", R.string.nebulosa_ojo_desc)
             intent.putExtra("EXTRA_IMAGE", R.drawable.nebulosa_ojo)
             startActivity(intent)
         }

         val cardAnillo = findViewById<CardView>(R.id.card_Anillo)
         cardAnillo.setOnClickListener {
             val intent = Intent(this, DetallesPlanetas::class.java)
             intent.putExtra("EXTRA_TITLE", R.string.nebulosa_anillo_titulo)
             intent.putExtra("EXTRA_DESCRIPTION", R.string.nebulosa_anillo_desc)
             intent.putExtra("EXTRA_IMAGE", R.drawable.nebulosa_anillo)
             startActivity(intent)
         }

    }
}