package com.example.proyectoprogra

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ConstelacionView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    // 1. El "Pincel" para las líneas
    private val paintLinea = Paint().apply {
        color = Color.parseColor("#FFD700") // Cambiar a DORADO para que combine
        strokeWidth = 5f // Un poco más fino es más elegante
        isAntiAlias = true
        style = Paint.Style.STROKE
    }

    // 2. El "Pincel" para las estrellas
    private val paintEstrella = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    // Coordenadas de las estrellas (X, Y) relativas (del 0 al 100 para escalar)
    // Ejemplo: Forma de la Osa Mayor (El Cazo)
    private val estrellas = listOf(
        Pair(0.1f, 0.4f), // Estrella 1
        Pair(0.3f, 0.35f), // Estrella 2
        Pair(0.5f, 0.45f), // Estrella 3
        Pair(0.6f, 0.55f), // Estrella 4
        Pair(0.6f, 0.75f), // Mango 1
        Pair(0.8f, 0.8f), // Mango 2
        Pair(0.9f, 0.6f)  // Mango 3
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val ancho = width.toFloat()
        val alto = height.toFloat()

        // 3. DIBUJAR LÍNEAS (Conectando estrellas)
        for (i in 0 until estrellas.size - 1) {
            val inicio = estrellas[i]
            val fin = estrellas[i+1]

            // Convertimos las coordenadas relativas a pixeles reales
            canvas.drawLine(
                inicio.first * ancho, inicio.second * alto,
                fin.first * ancho, fin.second * alto,
                paintLinea
            )
        }

        // Conexión especial para cerrar "El Cazo" (Osa Mayor)
        canvas.drawLine(
            estrellas[3].first * ancho, estrellas[3].second * alto,
            estrellas[6].first * ancho, estrellas[6].second * alto,
            paintLinea
        )

        // 4. DIBUJAR ESTRELLAS (Círculos)
        for (coord in estrellas) {
            canvas.drawCircle(
                coord.first * ancho,
                coord.second * alto,
                15f, // Radio de la estrella
                paintEstrella
            )
        }
    }
}