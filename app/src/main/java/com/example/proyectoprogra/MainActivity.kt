package com.example.proyectoprogra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.boton_iniciar)

        startButton.setOnClickListener {
            //Toast.makeText(this, "Iniciando Aventura...", Toast.LENGTH_SHORT).show()

            // Inicia la siguiente actividad
            val intent = Intent(this, Menu1::class.java)
            startActivity(intent)

            // Agrega transición de desvanecimiento
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        }
    }
}
