package com.desarrolloswesquel.todocomida.controladores

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.FragmentLocalesBinding
import com.desarrolloswesquel.todocomida.modelo.Local
import com.desarrolloswesquel.todocomida.modelo.carga.CargarLocal
import com.desarrolloswesquel.todocomida.controladores.adapters.LocalesAdapter


class LocalesFragment : Fragment(), SearchView.OnQueryTextListener {

    private var _binding: FragmentLocalesBinding? = null
    private val binding get() = _binding!!
    private var localesMutableList: MutableList<Local> =
        CargarLocal().listaLocales().toMutableList()
    private lateinit var adapter: LocalesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLocalesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.Buscar.setOnQueryTextListener(this)
        adapter = LocalesAdapter(localesMutableList) { local -> localClick(local) }
        val recyclerView = root.findViewById<RecyclerView>(R.id.ListadoLocales)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        return root
    }

    fun localClick(local: Local) {
        val intent = Intent(context, LocalActivity::class.java)
        intent.putExtra("nombrelocal", local.NombreLocal)
            .putExtra("rubrolocal", local.Rubro)
            .putExtra("direccionlocal", local.DireccionLocal)
            .putExtra("imagenlocal", local.ImagenLocal)
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onQueryTextSubmit(Buscar: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(Buscar: String): Boolean {
        filtrado(Buscar)
        return false
    }

    private fun filtrado(Buscar: String) {
        val listaFiltrado: ArrayList<Local> = ArrayList()

        for (local in localesMutableList) {
            if (local.NombreLocal.lowercase()
                    .contains(Buscar.lowercase()) ||
                local.Rubro.lowercase().contains(Buscar.lowercase())
            ) {
                listaFiltrado.add(local)
            }
        }
        adapter.filtrarLista(listaFiltrado)
    }
}

