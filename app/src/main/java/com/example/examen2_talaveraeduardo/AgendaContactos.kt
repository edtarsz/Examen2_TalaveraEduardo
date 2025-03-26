package com.example.examen2_talaveraeduardo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.Serializable

class AgendaContactos : AppCompatActivity() {
    companion object {
        val contactos = ArrayList<Contacto>()
        private var listaCargada = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agenda_contactos)

        val lvContacto: ListView = findViewById(R.id.lvContactos)
        val agregarContacto: Button = findViewById(R.id.btnAgregarContacto)

        agregarContacto.setOnClickListener {
            val intent = Intent(this, NuevoContacto::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras
        if (bundle != null) {
            val contacto: Serializable? = bundle.getSerializable("contacto")
            addContacto(contacto as Contacto)
        }

        if (!listaCargada) {
            llenarLista()
            listaCargada = true
        }

        val adaptador = ContactoAdapter(this, contactos)

        lvContacto.adapter = adaptador
    }

    private fun addContacto(contacto: Contacto) {
        contactos.add(contacto)
    }

    private fun llenarLista() {
        contactos.add(
            Contacto(
                "Luis",
                (Math.random() * 8 + 1).toInt(),
                "Jefe de cocina",
                "luis@gmail.com",
                "6553728327"
            )
        )
        contactos.add(
            Contacto(
                "Mario",
                (Math.random() * 8 + 1).toInt(),
                "Gerente de ventas",
                "mario@gmail.com",
                "6553728328"
            )
        )
        contactos.add(
            Contacto(
                "Juan",
                (Math.random() * 8 + 1).toInt(),
                "Desarrollador de software",
                "juan@gmail.com",
                "6553728329"
            )
        )
        contactos.add(
            Contacto(
                "Pedro",
                (Math.random() * 8 + 1).toInt(),
                "Diseñador gráfico",
                "pedro@gmail.com",
                "6553728330"
            )
        )
        contactos.add(
            Contacto(
                "Marcos",
                (Math.random() * 8 + 1).toInt(),
                "Director de marketing",
                "marcos@gmail.com",
                "6553728331"
            )
        )
        contactos.add(
            Contacto(
                "Sanchez",
                (Math.random() * 8 + 1).toInt(),
                "Supervisor de recursos humanos",
                "sanchez@gmail.com",
                "6553728332"
            )
        )
    }

}

class ContactoAdapter : BaseAdapter {
    var contactos = ArrayList<Contacto>()
    var context: Context? = null

    constructor(context: Context, contactos: ArrayList<Contacto>) {
        this.context = context
        this.contactos = contactos
    }

    override fun getCount(): Int {
        return contactos.size
    }

    override fun getItem(position: Int): Any {
        return contactos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var contacto = contactos[position]
        var inflador = LayoutInflater.from(context)
        var view = inflador.inflate(R.layout.activity_contacto, null)

        var nombre: TextView = view.findViewById(R.id.nombre)
        var rol: TextView = view.findViewById(R.id.rol)
        var circulo: View = view.findViewById(R.id.circle)
        var linearLayout: LinearLayout = view.findViewById(R.id.mainLinearLayout)
        var trash: ImageButton = view.findViewById(R.id.trash)

        nombre.text = contacto.nombre
        rol.text = contacto.rol

        if (context != null) {
            when (contacto.color) {
                1 -> circulo.setBackgroundColor(ContextCompat.getColor(context!!, R.color.random1))
                2 -> circulo.setBackgroundColor(ContextCompat.getColor(context!!, R.color.random2))
                3 -> circulo.setBackgroundColor(ContextCompat.getColor(context!!, R.color.random3))
                4 -> circulo.setBackgroundColor(ContextCompat.getColor(context!!, R.color.random4))
                5 -> circulo.setBackgroundColor(ContextCompat.getColor(context!!, R.color.random5))
                6 -> circulo.setBackgroundColor(ContextCompat.getColor(context!!, R.color.random6))
                7 -> circulo.setBackgroundColor(ContextCompat.getColor(context!!, R.color.random7))
                else -> circulo.setBackgroundColor(
                    ContextCompat.getColor(
                        context!!,
                        R.color.random8
                    )
                )
            }
        }

        linearLayout.setOnClickListener {
            val intent = Intent(context, DetallesContacto::class.java)

            intent.putExtra(
                "contacto", Contacto(
                    contacto.nombre,
                    contacto.color,
                    contacto.rol,
                    contacto.correo,
                    contacto.numero
                )
            )

            context?.startActivity(intent)
        }

        trash.setOnClickListener {
            removeContact(contacto)
        }

        return view
    }

    private fun removeContact(contacto: Contacto) {
        contactos.remove(contacto)
        val intent = Intent(context, AgendaContactos::class.java)
        context?.startActivity(intent)

    }
}