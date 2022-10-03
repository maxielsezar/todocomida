package com.desarrolloswesquel.todocomida.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Contacto

class ContactoAdapter(
    private var ListaContacto: MutableList<Contacto>

): RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    class ContactoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val linkContacto: TextView = view.findViewById(R.id.ItemLinkContacto)
        val imagenContacto: ImageView=view.findViewById(R.id.ItemContactoImagen)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val item = ListaContacto[position]
        holder.linkContacto.text = item.InfoContacto
        holder.imagenContacto.setImageResource(cargarImagen(item.TipoContacto.name))
    }

    override fun getItemCount() = ListaContacto.size


    private fun cargarImagen(TipoContacto: String): Int{
        val drawableResource = when (TipoContacto) {
            "NumTelefonoFijo" -> R.drawable.telefono
            "NumTelefonoMovil"-> R.drawable.celu
            "LinkFacebook"-> R.drawable.facebook
            "LinkWhatsapp"-> R.drawable.whatsapp
            "LinkInstagram"-> R.drawable.instagram
            else -> R.drawable.otros
        }
        return drawableResource
    }


}