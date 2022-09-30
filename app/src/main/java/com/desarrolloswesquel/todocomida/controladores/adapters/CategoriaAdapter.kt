package com.desarrolloswesquel.todocomida.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Categoria
import com.desarrolloswesquel.todocomida.controladores.InicioFragment


class CategoriaAdapter(
    private val context: InicioFragment,
    private val ListCategorias: List<Categoria>,
    private val OnCategoriaClickListener:(Categoria) ->Unit

) : RecyclerView.Adapter<CategoriaAdapter.categoriaViewHolder>() {

    class categoriaViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nombreCategoria: TextView = view.findViewById(R.id.ItemCategoriaNombre)
        val ImagenCategoria: ImageView = view.findViewById(R.id.ItemCategoriaImagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoriaViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria, parent, false)

        return categoriaViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: categoriaViewHolder, position: Int) {
        val item = ListCategorias[position]
        holder.nombreCategoria.text = item.NombreCategoria
        holder.ImagenCategoria.setImageResource(item.ImagenCategoria)
        holder.itemView.setOnClickListener { OnCategoriaClickListener(item) }
    }

    override fun getItemCount() = ListCategorias.size
}
