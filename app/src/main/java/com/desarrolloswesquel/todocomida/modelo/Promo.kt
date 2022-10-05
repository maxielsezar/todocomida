package com.desarrolloswesquel.todocomida.modelo

import java.util.*

data class Promo(
    val IdPromo: Int,
    val NombrePromo: String,
    val Descripcion: String,
    val FechaInicioPromo: Date,
    val FechaFinPromo: Date
)
