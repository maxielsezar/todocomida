package com.desarrolloswesquel.todocomida.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Local

class LocalesAdapter(
    private var ListLocales: MutableList<Local>,
    private val OnLocalClickListener:(Local) ->Unit

): RecyclerView.Adapter<LocalesAdapter.localesViewHolder>() {

    class localesViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val nombreLocal: TextView = view.findViewById(R.id.ItemLocalNombre)
        val rubroLocal: TextView = view.findViewById(R.id.ItemLocalRubro)
        val direccionLocal: TextView = view.findViewById(R.id.ItemLocalDireccion)
        val ImagenLocal: ImageView = view.findViewById(R.id.ItemLocalImagen)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): localesViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_local, parent, false)
        return localesViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: localesViewHolder, position: Int) {
        val item = ListLocales[position]
        holder.nombreLocal.text = item.NombreLocal
        holder.rubroLocal.text = item.Rubro
        holder.direccionLocal.text = item.DireccionLocal
        holder.ImagenLocal.setImageResource(item.ImagenLocal)
        holder.itemView.setOnClickListener { OnLocalClickListener(item) }
    }

    fun filtrarLista(listaFiltrada: ArrayList<Local>) {
        ListLocales = listaFiltrada
        notifyDataSetChanged()
    }

    override fun getItemCount() = ListLocales.size

}