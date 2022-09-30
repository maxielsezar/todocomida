package com.desarrolloswesquel.todocomida.controladores

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.controladores.adapters.ProductoAdapter
import com.desarrolloswesquel.todocomida.databinding.ActivityLocalBinding
import com.desarrolloswesquel.todocomida.modelo.Producto
import com.desarrolloswesquel.todocomida.modelo.carga.CargarProducto

class LocalActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLocalBinding
    private var productoMutableList: MutableList<Producto> =
        CargarProducto().listaProducto().toMutableList()
    private lateinit var adapter: ProductoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        binding = ActivityLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarpantalla()
        adapter = ProductoAdapter(productoMutableList)
        val recyclerView = binding.ListadoProducto
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }

    private fun cargarpantalla() {
        binding.ItemLocalNombre.text = intent.getStringExtra("nombrelocal")
        binding.ItemLocalRubro.text = intent.getStringExtra("rubrolocal")
        binding.ItemLocalDireccion.text = intent.getStringExtra("direccionlocal")
        binding.ItemLocalImagen.setImageResource(intent.extras?.get("imagenlocal") as Int)
    }


}