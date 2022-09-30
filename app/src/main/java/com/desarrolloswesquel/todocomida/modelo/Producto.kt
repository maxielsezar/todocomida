package com.desarrolloswesquel.todocomida.modelo

data class Producto(
    val IdProducto: Int,
    val IdLocal: Int,
    val NombreProducto: String,
    val PrecioProducto: Int,
    val Descripcion: String,
    val ImagenProducto: Int
)
