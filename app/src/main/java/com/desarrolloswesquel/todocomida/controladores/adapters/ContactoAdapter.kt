package com.desarrolloswesquel.todocomida.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Contacto

class ContactoAdapter(
    private var ListaContacto: MutableList<Contacto>,
    private val OnContactoClickListener: (Contacto) -> Unit

) : RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    class ContactoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenContacto: ImageView = view.findViewById(R.id.ItemContactoImagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val item = ListaContacto[position]
        holder.imagenContacto.setImageResource(cargarImagen(item.TipoContacto.name))
        holder.imagenContacto.setOnClickListener { OnContactoClickListener(item) }
    }


    override fun getItemCount() = ListaContacto.size


    private fun cargarImagen(TipoContacto: String): Int {
        val ImagenContacto = when (TipoContacto) {
            "NumTelefonoFijo" -> R.drawable.telefono
            "NumTelefonoMovil" -> R.drawable.celu
            "LinkFacebook" -> R.drawable.facebook
            "LinkWhatsapp" -> R.drawable.whatsapp
            "LinkInstagram" -> R.drawable.instagram
            else -> R.drawable.otros
        }
        return ImagenContacto
    }

}