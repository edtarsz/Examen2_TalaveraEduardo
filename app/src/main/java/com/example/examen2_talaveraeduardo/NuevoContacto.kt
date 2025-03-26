package com.example.examen2_talaveraeduardo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

class NuevoContacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_contacto)

        var nombre: EditText = findViewById(R.id.etNombre)
        var apellidos: EditText = findViewById(R.id.etApellido)
        var telefono: EditText = findViewById(R.id.etTelefono)
        var email: EditText = findViewById(R.id.etEmail)
        var rol: EditText = findViewById(R.id.etRol)

        var btnGuardar: Button = findViewById(R.id.btnGuardarContacto)

        val listaContactos = AgendaContactos.contactos

        btnGuardar.setOnClickListener {
            val intent = Intent(this, AgendaContactos::class.java)

            val nombre = nombre.text.toString() + " " + apellidos.text.toString()
            listaContactos.add(
                Contacto(
                    nombre,
                    (Math.random() * 8 + 1).toInt(),
                    rol.text.toString(),
                    email.text.toString(),
                    telefono.text.toString()
                )
            )
            startActivity(intent)
        }
    }
}