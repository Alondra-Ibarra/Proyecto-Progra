package com.example.proyectoprogra

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.text.Html  //Para que funcione todo lo HTML

class DetallesPlanetas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalles_planetas) // Carga el nuevo layout

        // 1. Busca las vistas en el layout de detalle
        val titleTextView = findViewById<TextView>(R.id.detalle_title)
        val descriptionTextView = findViewById<TextView>(R.id.detalle_description)
        val imageView = findViewById<ImageView>(R.id.detalle_image)

        // 2. Recibe los IDs que envió la 'PlanetasActivity'
        // Se usa 0 como valor por defecto si no se encuentra nada (aunque no debería pasar)
        val titleResId = intent.getIntExtra("EXTRA_TITLE", 0)
        val descriptionResId = intent.getIntExtra("EXTRA_DESCRIPTION", 0)
        val imageResId = intent.getIntExtra("EXTRA_IMAGE", 0)

        // 3. Valida que los IDs no sean 0 y usa los recursos
        if (titleResId != 0 && descriptionResId != 0 && imageResId != 0) {
            // Usa getString() para "llamar" el texto desde strings.xml
            titleTextView.text = getString(titleResId)
            descriptionTextView.text = getString(descriptionResId)

            // Usa setImageResource() para "llamar" la imagen desde drawable
            imageView.setImageResource(imageResId)

            val textoHtml = getString(descriptionResId)
            descriptionTextView.text = Html.fromHtml(textoHtml, Html.FROM_HTML_MODE_LEGACY)
        }
    }
}