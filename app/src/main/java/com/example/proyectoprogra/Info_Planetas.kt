package com.example.proyectoprogra

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info_Planetas(
    val nombre: String,
    val imagen: String,
    val descripcion: String
) : Parcelable

