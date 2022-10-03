package com.desarrolloswesquel.todocomida.modelo.carga

import com.desarrolloswesquel.todocomida.modelo.Contacto
import com.desarrolloswesquel.todocomida.modelo.MetodosContactos

class CargaContacto() {

    fun listaContacto(): List<Contacto> {
        return listOf<Contacto>(
            Contacto(
                0,
                0,
                MetodosContactos.NumTelefonoFijo,
                "02945 45-3800"
            ),
            Contacto(
                1,
                0,
                MetodosContactos.NumTelefonoMovil,
                "2945583234"
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
                "2945583234"
            ),
            Contacto(
                4,
                0,
                MetodosContactos.LinkWhatsapp,
                "2945583234"
            ),

            Contacto(
                6,
                9,
                MetodosContactos.NumTelefonoMovil,
                "02945 59-5915"
            ),
            Contacto(
                7,
                9,
                MetodosContactos.LinkFacebook,
                "https://es-la.facebook.com/cerveceria.amancay/"
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
                MetodosContactos.LinkWhatsapp,
                "cerveceriaamancay.com"
            )
        )
    }
}