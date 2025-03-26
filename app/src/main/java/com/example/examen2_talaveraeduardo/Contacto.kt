package com.example.examen2_talaveraeduardo

import java.io.Serializable

data class Contacto(
    var nombre: String,
    var color: Int,
    var rol: String,
    var correo: String,
    var numero: String
) : Serializable
