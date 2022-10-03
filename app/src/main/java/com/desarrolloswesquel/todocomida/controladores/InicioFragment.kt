package com.desarrolloswesquel.todocomida.controladores

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.FragmentInicioBinding
import com.desarrolloswesquel.todocomida.modelo.Categoria
import com.desarrolloswesquel.todocomida.modelo.carga.CargarCategoria
import com.desarrolloswesquel.todocomida.controladores.adapters.CategoriaAdapter

class InicioFragment : Fragment(){

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val datosCategorias = CargarCategoria().listaCategoria()
        val recyclerView = root.findViewById<RecyclerView>(R.id.ListadoCategorias)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = CategoriaAdapter(this, datosCategorias,{Categoria -> onItemClick(Categoria)})
        recyclerView.setHasFixedSize(true)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onItemClick(categoria : Categoria) {
        val intent = Intent(context, CategoriaActivity::class.java)
        intent  .putExtra("nombrecategoria", categoria.NombreCategoria)
            .putExtra("imagencategoria", categoria.ImagenCategoria)
            .putExtra("IdCategoria",categoria.IDCategoria)
        startActivity(intent)
    }
}