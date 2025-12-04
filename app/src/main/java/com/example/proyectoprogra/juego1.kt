package com.example.proyectoprogra

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.os.CountDownTimer
import android.view.MotionEvent
import android.graphics.Color
import android.graphics.drawable.Drawable


class juego1: AppCompatActivity() {
    // Variables para el arrastre (Drag)
    private var dX = 0f // Diferencia entre el dedo y la nave

    // Variables del juego
    private var respuestaCorrectaIndex = 0
    private var indicePreg=0
    private var anchoPantalla = 0

    private var listapregDif=listOf<Preguntas_Cuest>()

    private val preguntas=listOf(
        Preguntas_Cuest("¿Cuál es el planeta más grande?", "Tierra", "Júpiter", "Marte", 1, 1),
        Preguntas_Cuest("¿Dónde está el cinturón de asteroides?", "Tierra-Marte", "Marte-Júpiter", "Júpiter-Saturno", 1, 2),
        Preguntas_Cuest("¿Límite de un agujero negro?", "Singularidad", "Horizonte sucesos", "Espaguetización", 1, 3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.juego)

        val dificultadSelec=intent.getIntExtra("dificultad",1)
        listapregDif=preguntas.filter { it.dificultad==dificultadSelec }

        cargarPreLista()

        // 1. Referencias
        val nave = findViewById<ImageView>(R.id.ivNave)
        val tvTiempo = findViewById<TextView>(R.id.tvTiempo)

        // Calculamos el ancho de la pantalla para saber dónde están los carriles
        anchoPantalla = resources.displayMetrics.widthPixels

        // 2. Configurar la pregunta
        

        // 3. ACTIVAR EL ARRASTRE DE LA NAVE
        nave.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Guardamos la distancia inicial para que el movimiento sea suave
                    dX = view.x - event.rawX
                }
                MotionEvent.ACTION_MOVE -> {
                    // Movemos la nave siguiendo el dedo (solo en horizontal X)
                    var nuevaPosicion = event.rawX + dX

                    // (Opcional) Limites para que no se salga de la pantalla
                    if (nuevaPosicion < 0) nuevaPosicion = 0f
                    if (nuevaPosicion > anchoPantalla - view.width) nuevaPosicion = (anchoPantalla - view.width).toFloat()

                    view.animate()
                        .x(nuevaPosicion)
                        .setDuration(0) // 0 para que sea instantáneo
                        .start()
                }
            }
            true // Indica que hemos "consumido" el evento
        }

        // 4. INICIAR EL TEMPORIZADOR (Ejemplo: 5 segundos)
        iniciarTemporizador(5000, tvTiempo, nave)
    }

    // --- FUNCIONES ---

    private fun iniciarTemporizador(duracion: Long, textoTiempo: TextView, nave: View) {
        object : CountDownTimer(duracion, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Actualiza el texto cada segundo: "4...", "3..."
                textoTiempo.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                textoTiempo.text = "0"
                // AL ACABAR EL TIEMPO:
                // Bloqueamos la nave para que no se mueva más
                nave.setOnTouchListener(null)

                // Revisamos dónde quedó
                verificarPosicionFinal(nave)
            }
        }.start()
    }

    private fun verificarPosicionFinal(nave: View) {
        // Calculamos el centro de la nave
        val centroNave = nave.x + (nave.width / 2)

        // Dividimos la pantalla en 3 tercios matemáticos
        val tercioPantalla = anchoPantalla / 3

        var carrilSeleccionado = -1 // -1 = Error

        // Lógica matemática para saber el carril
        if (centroNave < tercioPantalla) {
            carrilSeleccionado = 0 // IZQUIERDA
        } else if (centroNave < tercioPantalla * 2) {
            carrilSeleccionado = 1 // CENTRO
        } else {
            carrilSeleccionado = 2 // DERECHA
        }

        // Comparamos con la respuesta correcta
        if (carrilSeleccionado == respuestaCorrectaIndex) {
            mostrarDialogo("¡ASTEROIDE DESTRUIDO!","Mc Alien celebra tu victoria.",100, R.drawable.marciano_celeb, Color.GREEN)
        } else {
            mostrarDialogo("¡EL ASTEROIDE IMPACTO!","Mc Alien sufre daño.", 0, R.drawable.marciano_triste, Color.RED)
        }
    }

    private fun cargarPreLista(){
        if(indicePreg<listapregDif.size){
            val preg=listapregDif[indicePreg]
            cargarPregunta(preg.pregunta,preg.respuesta1,preg.respuesta2,preg.respuesta3,preg.respuestaCorrecta)
        }else{
            Toast.makeText(this,"No hay mas preguntas", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun cargarPregunta(pregunta: String, op1: String, op2: String, op3: String, correcta: Int) {
        findViewById<TextView>(R.id.tvPregunta).text = pregunta
        findViewById<TextView>(R.id.tvRespuesta1).text = op1
        findViewById<TextView>(R.id.tvRespuesta2).text = op2
        findViewById<TextView>(R.id.tvRespuesta3).text = op3
        respuestaCorrectaIndex = correcta
    }

    private fun mostrarDialogo(mensaje:String,mensaje2:String, puntaje:Int, imagen: Int, color: Int){
        val dialog= Dialog(this)
        dialog.setContentView(R.layout.pantalla2juego)
        dialog.setCancelable(false)

        val tvPuntajeValor=dialog.findViewById<TextView>(R.id.tvPuntajeValor)
        val tvMensaje=dialog.findViewById<TextView>(R.id.textView)
        val tvMensaje2=dialog.findViewById<TextView>(R.id.tvMensaje2)
        val imageView=dialog.findViewById<ImageView>(R.id.imageView)


        tvPuntajeValor.text=puntaje.toString()
        tvMensaje.text=mensaje
        tvMensaje2.text=mensaje2
        imageView.setImageResource(imagen)

        tvMensaje.setTextColor(color)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnSiguiente=dialog.findViewById<View>(R.id.btnSiguiente)
        val btnMenu=dialog.findViewById<View>(R.id.btnMenu)

        btnSiguiente.setOnClickListener{
            dialog.dismiss()
            reiniciar()
        }

        btnMenu.setOnClickListener{
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun reiniciar(){
        val nave=findViewById<ImageView>(R.id.ivNave)
        val tvTiempo=findViewById<TextView>(R.id.tvTiempo)

        nave.x=(anchoPantalla/2f)-(nave.width/2f)

        setupTouchListener(nave)

        cargarPregunta("¿Planeta Rojo?", "Tierra", "Marte", "Venus",1)
        iniciarTemporizador(5000,tvTiempo,nave)

    }

    private fun setupTouchListener(nave: View) {
        nave.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Guardamos la distancia inicial para que el movimiento sea suave
                    dX = view.x - event.rawX
                }
                MotionEvent.ACTION_MOVE -> {
                    // Movemos la nave siguiendo el dedo (solo en horizontal X)
                    var nuevaPosicion = event.rawX + dX

                    // (Opcional) Limites para que no se salga de la pantalla
                    if (nuevaPosicion < 0) nuevaPosicion = 0f
                    if (nuevaPosicion > anchoPantalla - view.width) nuevaPosicion = (anchoPantalla - view.width).toFloat()

                    view.animate()
                        .x(nuevaPosicion)
                        .setDuration(0) // 0 para que sea instantáneo
                        .start()
                }
            }
            true // Indica que hemos "consumido" el evento
        }
    }
}