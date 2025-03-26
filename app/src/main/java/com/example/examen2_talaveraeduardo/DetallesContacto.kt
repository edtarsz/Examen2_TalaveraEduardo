package com.example.examen2_talaveraeduardo

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

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

        nombre.text = contacto.nombre
        rol.text = contacto.rol
        correo.text = contacto.correo
        numero.text = contacto.numero

        when (contacto.color) {
            1 -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random1))
            2 -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random2))
            3 -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random3))
            4 -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random4))
            5 -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random5))
            6 -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random6))
            7 -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random7))
            else -> color.setBackgroundColor(ContextCompat.getColor(this, R.color.random8))
        }

    }
}