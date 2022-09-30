package com.desarrolloswesquel.todocomida.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Producto

class ProductoAdapter(
    private var ListaProducto: MutableList<Producto>

): RecyclerView.Adapter<ProductoAdapter.localesViewHolder>() {

    class localesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nombreproducto: TextView = view.findViewById(R.id.ItemProductoNombre)
        val descripcionProducto: TextView = view.findViewById(R.id.ItemProductoDescripcion)
        val precioProducto: TextView = view.findViewById(R.id.ItemProductoPrecio)
        val imagenProducto: ImageView = view.findViewById(R.id.ItemProductoImagen)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): localesViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return localesViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: localesViewHolder, position: Int) {
        val item = ListaProducto[position]
        holder.nombreproducto.text = item.NombreProducto
        holder.descripcionProducto.text = item.Descripcion
        holder.precioProducto.text = item.PrecioProducto.toString()
        holder.imagenProducto.setImageResource(item.ImagenProducto)
    }

    override fun getItemCount() = ListaProducto.size

}