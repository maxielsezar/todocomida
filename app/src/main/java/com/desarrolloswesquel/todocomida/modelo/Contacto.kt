package com.desarrolloswesquel.todocomida.modelo

data class Contacto(
    val IDContacto: Int,
    val IDLocal: Int,
    val NumTelefonoFijo: String,
    val NumTelefonoMovil: String,
    val linkFacebook: String,
    val linkWhatsapp: String,
    val linkInstagram: String
)
