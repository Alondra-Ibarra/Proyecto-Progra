package com.example.proyectoprogra // Asegúrate de que este sea tu paquete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Carga tu layout. MotionLayout se activará automáticamente.
        setContentView(R.layout.activity_main)

        // 2. Busca el botón por su ID
        val startButton = findViewById<Button>(R.id.boton_iniciar)

        // 3. Asigna la acción de clic
        startButton.setOnClickListener {
            // Acción al hacer clic.
            // Por ejemplo, mostrar un mensaje:
            Toast.makeText(this, "Iniciando Aventura...", Toast.LENGTH_SHORT).show()

            // O (lo más probable) iniciar tu siguiente actividad:
            // val intent = Intent(this, TuSiguienteActividad::class.java)
            // startActivity(intent)
        }
    }
}