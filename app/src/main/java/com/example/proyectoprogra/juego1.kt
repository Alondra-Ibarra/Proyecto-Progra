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
import java.io.File
import android.content.Context
import android.graphics.drawable.Drawable
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.widget.ImageButton
import android.hardware.Sensor
import android.hardware.SensorEvent

class juego1: AppCompatActivity(), SensorEventListener {
    // Variables para el arrastre (Drag)
    private var dX = 0f // Diferencia entre el dedo y la nave

    // Variables del juego

    //Para los sensores
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var carrilPrim=1

    private var mediaPlayer: MediaPlayer? = null
    private var tiempo: CountDownTimer?=null
    private var tiempoRestante:Long=9000

    private var respuestaCorrectaIndex = 0
    private var indicePreg=0
    private var anchoPantalla = 0

    private var puntaje=0
    private val nomArch="record_max.txt"

    private var listapregDif=listOf<Preguntas_Cuest>()

    private val preguntas=listOf(
        Preguntas_Cuest("¿Cuál es el planeta más pequeño?", "Tierra", "Mercurio", "Júpiter", 1, 1),
        Preguntas_Cuest("¿Qué planeta es el 'Planeta Rojo'?", "Venus", "Marte", "Saturno", 1, 1),
        Preguntas_Cuest("¿Cuál es el planeta más caliente?", "Venus", "Mercurio", "Marte", 0, 1),
        Preguntas_Cuest("¿Qué hace famoso a Saturno?", "Es rojo", "Tiene anillos", "Es cuadrado", 1, 1),
        Preguntas_Cuest("¿Cómo se llama nuestra galaxia?", "Andrómeda", "Vía Láctea", "Agujero Negro", 1, 1),
        Preguntas_Cuest("¿Qué planeta tiene la Gran Mancha Roja?", "Júpiter", "Neptuno", "Urano", 0, 1),
        Preguntas_Cuest("¿Cuánta agua cubre la Tierra?", "10%", "70%", "100%", 1, 1),
        Preguntas_Cuest("¿Plutón es un planeta mayor?", "Sí", "No, es enano", "No, es estrella", 1, 1),

        // --- NIVEL MEDIO (2) ---
        Preguntas_Cuest("¿Dónde está el Cinturón de Asteroides?", "Tierra-Marte", "Marte-Júpiter", "Tras Plutón", 1, 2),
        Preguntas_Cuest("¿Qué gas hace azul a Urano?", "Oxígeno", "Metano", "Helio", 1, 2),
        Preguntas_Cuest("¿Cuántas constelaciones existen?", "12", "50", "88", 2, 2),
        Preguntas_Cuest("¿Qué son las nebulosas?", "Planetas", "Nubes de gas", "Cometas", 1, 2),
        Preguntas_Cuest("¿Qué planeta rota de lado?", "Tierra", "Urano", "Marte", 1, 2),
        Preguntas_Cuest("¿Cuál es la galaxia vecina?", "Andrómeda", "Sagitario", "Orión", 0, 2),
        Preguntas_Cuest("¿Exoplaneta parecido a la Tierra?", "Kepler-452b", "Saturno", "Eris", 0, 2),
        Preguntas_Cuest("¿Qué son los Gigantes Gaseosos?", "Rocas", "Planetas de gas", "Estrellas", 1, 2),

        // --- NIVEL DIFÍCIL (3) ---
        Preguntas_Cuest("¿Duración de la señal Wow!?", "72 segundos", "1 hora", "10 minutos", 0, 3),
        Preguntas_Cuest("¿Causa probable de señal Wow!?", "Aliens", "Nubes Hidrógeno", "Satélite", 1, 3),
        Preguntas_Cuest("¿Límite de un agujero negro?", "Singularidad", "Horizonte Sucesos", "Zona oscura", 1, 3),
        Preguntas_Cuest("¿Efecto de un agujero negro?", "Congelación", "Espaguetización", "Vaporización", 1, 3),
        Preguntas_Cuest("¿Imágenes en el Disco de Oro?", "50", "115", "1000", 1, 3),
        Preguntas_Cuest("¿Qué es 3i/ATLAS?", "Planeta", "Cometa Interestelar", "Nave", 1, 3),
        Preguntas_Cuest("¿Qué es una Enana Blanca?", "Estrella bebé", "Núcleo muerto", "Planeta", 1, 3),
        Preguntas_Cuest("¿Idiomas en el Disco de Oro?", "10", "55", "100", 1, 3)
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
        val btnPausa=findViewById<ImageButton>(R.id.btnPausa)

        // Calculamos el ancho de la pantalla para saber dónde están los carriles
        anchoPantalla = resources.displayMetrics.widthPixels

        // Configuramos Pausa
        btnPausa.setOnClickListener{
            pausar()
        }
        

        // 3. ACTIVAR EL ARRASTRE DE LA NAVE
        sensorManager=getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

//        setupTouchListener(nave)

        // 4. INICIAR EL TEMPORIZADOR (Ejemplo: 5 segundos)
        iniciarTemporizador(9000, tvTiempo, nave)

        //musica

        mediaPlayer = MediaPlayer.create(this, R.raw.fondo_cuest)
        mediaPlayer?.isLooping=true
        mediaPlayer?.start()
        mediaPlayer?.setVolume(0.5f,0.5f)
    }

    // --- FUNCIONES ---

    override fun onDestroy() {
        super.onDestroy()
        if(mediaPlayer!=null){
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer=null
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        sensorManager.unregisterListener(this)
    }

    // Y que vuelva a arrancar al volver
    override fun onResume() {
        super.onResume()
        mediaPlayer?.start()

        accelerometer?.let{
            sensorManager.registerListener(this,it,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }


    private fun obtenerMejorPuntaje(): Int {
        val file = File(filesDir, nomArch)

        // Si el archivo no existe (primera vez que juega), devolvemos 0
        if (!file.exists()) {
            return 0
        }

        return try {
            // openFileInput lee el archivo privado de la app
            val textoLeido = openFileInput(nomArch).bufferedReader().use {
                it.readText()
            }
            // Convertimos el texto "100" a número entero 100
            if (textoLeido.isNotEmpty()) textoLeido.toInt() else 0
        } catch (e: Exception) {
            0 // Si falla algo, devolvemos 0
        }
    }
    private fun guardarNuevoRecord(nuevoPuntaje: Int) {
        val contenido = nuevoPuntaje.toString() // Convertimos número a texto

        try {
            // MODE_PRIVATE: Solo esta app puede leer este archivo
            openFileOutput(nomArch, Context.MODE_PRIVATE).use { out ->
                out.write(contenido.toByteArray())
            }
            Toast.makeText(this, "¡Nuevo Récord Guardado en Memoria Interna!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun iniciarTemporizador(duracion: Long, textoTiempo: TextView, nave: View) {
        tiempo?.cancel()
       tiempo=object : CountDownTimer(duracion, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Actualiza el texto cada segundo: "4...", "3..."
                tiempoRestante=millisUntilFinished
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

    private fun pausar(){
        tiempo?.cancel()
        if(mediaPlayer?.isPlaying==true){
            mediaPlayer?.pause()
        }
        val nave=findViewById<ImageView>(R.id.ivNave)
        nave.setOnTouchListener(null)
        mostrarPausaDialogo()
    }

    private fun reanudar(){
        val nave=findViewById<ImageView>(R.id.ivNave)
        val tiempo=findViewById<TextView>(R.id.tvTiempo)
//        setupTouchListener(nave)
        mediaPlayer?.start()
        iniciarTemporizador(tiempoRestante,tiempo,nave)

    }

    private fun mostrarPausaDialogo(){
        val dialog= Dialog(this)
        dialog.setContentView(R.layout.pausa_card)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnReanudar=dialog.findViewById<View>(R.id.btnReanudar)
        val btnSalir=dialog.findViewById<View>(R.id.btnSalir)

        btnReanudar.setOnClickListener{
            dialog.dismiss()
            reanudar()
        }

        btnSalir.setOnClickListener{
            dialog.dismiss()
            finish()
        }

        dialog.show()
    }

    private fun verificarPosicionFinal(nave: View) {

        // Comparamos con la respuesta correcta
        if (carrilPrim == respuestaCorrectaIndex) {
            puntaje+=100
            val recordActual = obtenerMejorPuntaje()
            if (puntaje > recordActual) {
                guardarNuevoRecord(puntaje)
            }
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
            finish()
        }

        dialog.show()
    }

    private fun reiniciar(){
        indicePreg++

        if(indicePreg<listapregDif.size){
            val nave=findViewById<ImageView>(R.id.ivNave)
            val tvTiempo=findViewById<TextView>(R.id.tvTiempo)
            nave.x=(anchoPantalla/2f)-(nave.width/2f)
//            setupTouchListener(nave)
            cargarPreLista()
            iniciarTemporizador(9000,tvTiempo,nave)

        }else{
            mostrarDialogoFinal()
        }


    }

    private fun mostrarDialogoFinal(){
        val recordActual = obtenerMejorPuntaje()


        if (puntaje > recordActual) {
            guardarNuevoRecord(puntaje)
        }


        val dialog = Dialog(this)
        dialog.setContentView(R.layout.pantalla2juego)
        dialog.setCancelable(false)

        val tvTitulo = dialog.findViewById<TextView>(R.id.textView)
        val tvSubtitulo = dialog.findViewById<TextView>(R.id.tvMensaje2)
        val tvPuntaje = dialog.findViewById<TextView>(R.id.tvPuntajeValor)
        val img = dialog.findViewById<ImageView>(R.id.imageView)
        val btnSiguiente = dialog.findViewById<View>(R.id.btnSiguiente)
        val btnMenu = dialog.findViewById<View>(R.id.btnMenu)

        tvTitulo.text = "¡MISIÓN CUMPLIDA!"
        tvTitulo.setTextColor(Color.parseColor("#FFD700"))

        // Mostramos: Tu Puntos / Récord Actual
        tvSubtitulo.text = "Puntos: $puntaje  |  Récord: ${if(puntaje > recordActual) puntaje else recordActual}"

        tvPuntaje.text = puntaje.toString()
        img.setImageResource(R.drawable.marciano_celeb)

        // Ocultar botón siguiente
        btnSiguiente.visibility = View.GONE

        btnMenu.setOnClickListener {
            dialog.dismiss()
            finish()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0] // Inclinación lateral


            val umbral = 3.5f

            val umbralRetorno = 1.5f

            var nuevoCarril = carrilPrim


            if (carrilPrim == 1) {
                if (x > umbral) {
                    nuevoCarril = 0 // Ir a Izquierda
                } else if (x < -umbral) {
                    nuevoCarril = 2 // Ir a Derecha
                }
            }
            else if (carrilPrim == 0) {
                if (x < -umbralRetorno) {
                    nuevoCarril = 1
                }
            }

            else if (carrilPrim == 2) {

                if (x > umbralRetorno) {
                    nuevoCarril = 1
                }
            }


            if (nuevoCarril != carrilPrim) {
                carrilPrim = nuevoCarril
                moverNave(carrilPrim)
            }
        }
    }

    private fun moverNave(nuevoCarril:Int){
        val nave = findViewById<ImageView>(R.id.ivNave)
        val anchoNave = nave.width

        val posicionIzquierda = (anchoPantalla / 6f) - (anchoNave / 2f)
        val posicionCentro = (anchoPantalla / 2f) - (anchoNave / 2f)
        val posicionDerecha = (anchoPantalla * 5f / 6f) - (anchoNave / 2f)

        var destinoX = 0f

        when (nuevoCarril) {
            0 -> destinoX = posicionIzquierda
            1 -> destinoX = posicionCentro
            2 -> destinoX = posicionDerecha
        }

        nave.animate()
            .x(destinoX)
            .setDuration(200)
            .start()
    }
}