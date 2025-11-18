package com.example.proyectoprogra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.cardview.widget.CardView

class Planetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Con esto se carga el layout creado
        setContentView(R.layout.planetas)

        val ListaPlanetas = listOf(
            Info_Planetas("Mercurio", "mercurio", "Descripción del planeta Mercurio")
        )

        // 2. Aquí es donde pones la lógica para CADA tarjeta de planeta
        // (Más tarde, aquí pondrás los clics para ir a DetalleActivity)

        // Ejemplo para Mercurio:
        val cardMercurio = findViewById<CardView>(R.id.card_mercurio)
        cardMercurio.setOnClickListener {

            // Creamos el Intent para ir a DetallesPlanetas
            val intent = Intent(this, DetallesPlanetas::class.java)

            // Ponemos los IDs de los strings y la imagen que queremos mostrar
            intent.putExtra("EXTRA_TITLE", R.string.planeta_mercurio_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_mercurio_desc)
            intent.putExtra(
                "EXTRA_IMAGE",
                R.drawable.mercurio
            ) // (Asegúrate que esta imagen exista)

            // Iniciamos la pantalla de detalle
            startActivity(intent)
        }

        // (Repite esto para Venus, Tierra, Marte, Plutón, etc.)

        val cardVenus = findViewById<CardView>(R.id.card_venus)
        cardVenus.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_venus_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_venus_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.venus)
            startActivity(intent)
        }

        val cardTierra = findViewById<CardView>(R.id.card_tierra)
        cardTierra.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_tierra_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_tierra_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.tierra)
            startActivity(intent)
        }

        val cardMarte = findViewById<CardView>(R.id.card_marte)
        cardMarte.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_marte_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_marte_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.marte)
            startActivity(intent)

        }

        val cardJupiter = findViewById<CardView>(R.id.card_jupiter)
        cardJupiter.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_jupiter_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_jupiter_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.jupiter)
            startActivity(intent)
        }

        val cardSaturno = findViewById<CardView>(R.id.card_saturno)
        cardSaturno.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_saturno_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_saturno_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.saturno)
            startActivity(intent)
        }

        val cardUrano = findViewById<CardView>(R.id.card_urano)
        cardUrano.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_urano_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_urano_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.urano)
            startActivity(intent)
        }

        val cardNeptuno = findViewById<CardView>(R.id.card_neptuno)
        cardNeptuno.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_neptuno_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_neptuno_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.neptuno)
            startActivity(intent)
        }

        val cardPluton = findViewById<CardView>(R.id.card_pluton)
        cardPluton.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_pluton_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_pluton_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.pluton)
            startActivity(intent)
        }

        val cardEris = findViewById<CardView>(R.id.card_eris)
        cardEris.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_eris_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_eris_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.eris)
            startActivity(intent)
        }

        val cardHaumea = findViewById<CardView>(R.id.card_haumea)
        cardHaumea.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_haumea_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_haumea_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.haumea)
            startActivity(intent)
        }

        val cardMakemake = findViewById<CardView>(R.id.card_makemake)
        cardMakemake.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_makemake_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_makemake_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.makemake)
            startActivity(intent)
        }

        val cardCeres = findViewById<CardView>(R.id.card_ceres)
        cardCeres.setOnClickListener {
            val intent = Intent(this, DetallesPlanetas::class.java)
            intent.putExtra("EXTRA_TITLE", R.string.planeta_ceres_titulo)
            intent.putExtra("EXTRA_DESCRIPTION", R.string.planeta_ceres_desc)
            intent.putExtra("EXTRA_IMAGE", R.drawable.ceres)
            startActivity(intent)
        }


        // ...y así para todos los demás...
    }
}

