package com.desarrolloswesquel.todocomida.modelo

import java.util.*


data class Oferta(
    val IdOferta: Int,
    val IdProducto: Int,
    val NombreProducto: String,
    val PrecioOferta: Int,
    val Descuento: String,
    val FechaInicioOferta: Date,
    val FechaFinOferta: Date
)
