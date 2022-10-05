package com.desarrolloswesquel.todocomida.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Oferta
import com.desarrolloswesquel.todocomida.modelo.Producto

class OfertaAdapter(
    private var ListaOferta: MutableList<Oferta>

): RecyclerView.Adapter<OfertaAdapter.ofertaViewHolder>() {

    class ofertaViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nombreOferta: TextView = view.findViewById(R.id.ItemOfertaNombre)
        val descripcionOferta: TextView = view.findViewById(R.id.ItemOfertaDescripcion)
        val precioOferta: TextView = view.findViewById(R.id.ItemOfertaPrecio)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ofertaViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_oferta, parent, false)
        return ofertaViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ofertaViewHolder, position: Int) {
        val item = ListaOferta[position]
        holder.nombreOferta.text = item.NombreOferta
        holder.descripcionOferta.text = item.Descuento
        holder.precioOferta.text = item.PrecioOferta.toString()
    }

    override fun getItemCount() = ListaOferta.size

}