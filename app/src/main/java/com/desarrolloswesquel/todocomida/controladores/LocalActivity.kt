package com.desarrolloswesquel.todocomida.controladores

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.controladores.adapters.ContactoAdapter
import com.desarrolloswesquel.todocomida.controladores.adapters.ProductoAdapter
import com.desarrolloswesquel.todocomida.databinding.ActivityLocalBinding
import com.desarrolloswesquel.todocomida.modelo.Contacto
import com.desarrolloswesquel.todocomida.modelo.Local
import com.desarrolloswesquel.todocomida.modelo.Producto
import com.desarrolloswesquel.todocomida.modelo.carga.CargaContacto
import com.desarrolloswesquel.todocomida.modelo.carga.CargarProducto

class LocalActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLocalBinding
    private var productoMutableList: MutableList<Producto> =
        CargarProducto().listaProducto().toMutableList()
    private lateinit var adapterProducto: ProductoAdapter
    private lateinit var adapterContacto: ContactoAdapter
    private var contactoMutableList: MutableList<Contacto> =
        CargaContacto().listaContacto().toMutableList()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        binding = ActivityLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarpantalla()
        val idlocal = intent.extras?.get("idLocal") as Int
        val contactoLocal=filtrarContacto(idlocal)
        adapterProducto = ProductoAdapter(productoMutableList)
        adapterContacto = ContactoAdapter(contactoLocal) { contacto -> contactoClick(contacto) }
        val recyclerViewProducto = binding.ListadoProducto
        val recyclerViewContacto = binding.ListadoContacto
        recyclerViewProducto.adapter = adapterProducto
        recyclerViewContacto.adapter = adapterContacto
        recyclerViewProducto.setHasFixedSize(true)
        recyclerViewContacto.setHasFixedSize(true)
    }

    private fun filtrarContacto(idlocal: Int): ArrayList<Contacto> {
        val listaFiltrado: ArrayList<Contacto> = ArrayList()
        for (contacto in contactoMutableList) {
                if ( contacto.IDLocal == idlocal
                ) {
                    listaFiltrado.add(contacto)
                }
        }
        return listaFiltrado
    }

    private fun contactoClick(contacto: Contacto) {
        val link = Uri.parse(contacto.InfoContacto)
        val intent = Intent(Intent.ACTION_VIEW, link)
        startActivity(intent)
    }

    private fun cargarpantalla() {
        binding.ItemLocalNombre.text = intent.getStringExtra("nombrelocal")
        binding.ItemLocalRubro.text = intent.getStringExtra("rubrolocal")
        binding.ItemLocalDireccion.text = intent.getStringExtra("direccionlocal")
        binding.ItemLocalImagen.setImageResource(intent.extras?.get("imagenlocal") as Int)
    }

}