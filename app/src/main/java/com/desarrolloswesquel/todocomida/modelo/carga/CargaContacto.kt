package com.desarrolloswesquel.todocomida.modelo.carga

import com.desarrolloswesquel.todocomida.modelo.Contacto
import com.desarrolloswesquel.todocomida.modelo.MetodosContactos

class CargaContacto {

    fun listaContacto(): List<Contacto> {
        return listOf(
            Contacto(
                0,
                0,
                MetodosContactos.NumTelefonoFijo,
                "tel:+542945453800"
            ),
            Contacto(
                1,
                0,
                MetodosContactos.NumTelefonoMovil,
                "tel:2945583234"
            ),
            Contacto(
                2,
                0,
                MetodosContactos.LinkFacebook,
                "https://es-la.facebook.com/lalunaesquel/"
            ),
            Contacto(
                3,
                0,
                MetodosContactos.LinkInstagram,
                "https://www.instagram.com/lalunaesquel/?hl=es"
            ),
            Contacto(
                4,
                0,
                MetodosContactos.LinkWhatsapp,
                "https://wa.link/a9p22x"
            ),

            Contacto(
                6,
                9,
                MetodosContactos.NumTelefonoMovil,
                "tel:02945 59-5915"
            ),
            Contacto(
                7,
                9,
                MetodosContactos.LinkFacebook,
                "https://www.facebook.com/cerveceria.amancay"
            ),
            Contacto(
                8,
                9,
                MetodosContactos.LinkInstagram,
                "https://www.instagram.com/amancay_cerveceria/?hl=es"
            ),
            Contacto(
                9,
                9,
                MetodosContactos.PaginaWeb,
                "https://cerveceriaamancay.com.ar"
            )
        )
    }
}