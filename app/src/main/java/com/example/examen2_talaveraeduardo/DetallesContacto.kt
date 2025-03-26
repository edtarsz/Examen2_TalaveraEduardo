package com.example.examen2_talaveraeduardo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetallesContacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalles_contacto)

        var contacto: Contacto = intent.extras?.getSerializable("contacto") as Contacto

        var nombre: TextView = findViewById(R.id.nombreCompleto)
        var rol: TextView = findViewById(R.id.roldetalle)
        var correo: TextView = findViewById(R.id.correodetalle)
        var numero: TextView = findViewById(R.id.numerodetalle)
        var color: View = findViewById(R.id.bolota)
        var llamar: Button = findViewById(R.id.btnLlamar)

        var colgar: ImageButton = findViewById(R.id.btnColgar)

        llamar.setOnClickListener {
            llamar.visibility = View.GONE
            colgar.visibility = View.VISIBLE
        }

        colgar.setOnClickListener {
            llamar.visibility = View.VISIBLE
            colgar.visibility = View.GONE
        }

        nombre.text = contacto.nombre
        rol.text = contacto.rol
        correo.text = contacto.correo
        numero.text = contacto.numero
        llamar.text = "Llamar a " + contacto.nombre

        when (contacto.color) {
            1 -> color.setBackgroundResource(R.color.random1)
            2 -> color.setBackgroundResource(R.color.random2)
            3 -> color.setBackgroundResource(R.color.random3)
            4 -> color.setBackgroundResource(R.color.random4)
            5 -> color.setBackgroundResource(R.color.random5)
            6 -> color.setBackgroundResource(R.color.random6)
            7 -> color.setBackgroundResource(R.color.random7)
            else -> color.setBackgroundResource(R.color.random8)
        }

    }
}