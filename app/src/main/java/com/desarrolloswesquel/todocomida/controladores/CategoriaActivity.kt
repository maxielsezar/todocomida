package com.desarrolloswesquel.todocomida.controladores

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.controladores.adapters.LocalesAdapter
import com.desarrolloswesquel.todocomida.databinding.ActivityCategoriaBinding
import com.desarrolloswesquel.todocomida.modelo.Local
import com.desarrolloswesquel.todocomida.modelo.carga.CargaLocalesCategoria
import com.desarrolloswesquel.todocomida.modelo.carga.CargarLocal

class CategoriaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriaBinding
    private var localesMutableList: MutableList<Local> = CargarLocal().listaLocales().toMutableList()
    private var listaLocalesCategoria = CargaLocalesCategoria().listaLocalesCategoria()
    private lateinit var adapter: LocalesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
        binding = ActivityCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.extras != null) {
            binding.ItemCategoriaNombre.text = intent.getStringExtra("nombrecategoria")
            binding.ItemCategoriaImagen.setImageResource(intent.extras?.get("imagencategoria") as Int)

        }

        val categoria = intent.extras?.get("IdCategoria") as Int
        val listadoFiltrada =filtrarLista(categoria)
        adapter = LocalesAdapter(listadoFiltrada) { local -> localClick(local) }
        val recyclerView = binding.ListadoLocales
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }

    private fun filtrarLista(categoria: Int): ArrayList<Local> {
        val listaFiltrado: ArrayList<Local> = ArrayList()
        for (localesCategoria in listaLocalesCategoria) {
            for (local in localesMutableList){
                if (local.IdLocal == localesCategoria.IdLocal && localesCategoria.IdCategoria==categoria
                        ) {
                    listaFiltrado.add(local)
                }
            }
        }
        return listaFiltrado
    }

    fun localClick(local: Local) {
        val intent = Intent(this, LocalActivity::class.java)
        intent.putExtra("nombrelocal", local.NombreLocal)
            .putExtra("rubrolocal", local.Rubro)
            .putExtra("direccionlocal", local.DireccionLocal)
            .putExtra("imagenlocal", local.ImagenLocal)
        startActivity(intent)
    }
}
