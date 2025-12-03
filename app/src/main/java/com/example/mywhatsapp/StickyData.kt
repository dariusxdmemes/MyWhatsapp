package com.example.mywhatsapp

import androidx.annotation.DrawableRes

data class StickyData(
    val headerLabel: String,
    @DrawableRes val rutaImagen: Int,
    val nombreUsuario: String
)
