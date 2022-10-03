package com.desarrolloswesquel.todocomida.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Contacto

class ContactoAdapter(
    private var ListaContacto: MutableList<Contacto>

): RecyclerView.Adapter<ContactoAdapter.contactoViewHolder>() {

    class contactoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nombreContacto: TextView = view.findViewById(R.id.ItemTipoContacto)
        val linkContacto: TextView = view.findViewById(R.id.ItemLinkContacto)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return contactoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: contactoViewHolder, position: Int) {
        val item = ListaContacto[position]
        holder.nombreContacto.text = item.TipoContacto.name
        holder.linkContacto.text = item.InfoContacto
    }

    override fun getItemCount() = ListaContacto.size

}