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

        // 2. Aquí es donde pones la lógica para CADA tarjeta de planeta
        // (Más tarde, aquí pondrás los clics para ir a DetalleActivity)


        // (Repite esto para Venus, Tierra, Marte, Plutón, etc.)

        /*val cardVenus = findViewById<CardView>(R.id.card_venus)
        cardVenus.setOnClickListener {
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_venus_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_venus_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.venus)
            startActivity(intent)
        }*/

        // ...y así para todos los demás...
    }
}