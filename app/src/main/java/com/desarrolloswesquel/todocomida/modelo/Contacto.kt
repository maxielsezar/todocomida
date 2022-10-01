package com.desarrolloswesquel.todocomida.modelo

data class Contacto(
    val IDContacto: Int,
    val IDLocal: Int,
    val TipoContacto: MetodosContactos,
    val InfoContacto: String
)
