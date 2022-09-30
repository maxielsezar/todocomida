package com.desarrolloswesquel.todocomida.modelo.carga

import com.desarrolloswesquel.todocomida.modelo.Producto

class CargarProducto {
    fun listaProducto(): List<Producto> {
        return listOf<Producto>(
            Producto(
                0,
                1,
                "pizza roquefort",
                2000,
                "salsa, tomate, roquefort, muzzarela",
                0
            ),

            Producto(
                1,
                1,
                "pizza fugazzeta",
                2000,
                "salsa, tomate, roquefort, muzzarela",
                0
            ),

            Producto(
                2,
                1,
                "pizza de anana",
                2000,
                "salsa, cebolla, morron, jamon, anana, muzzarela",
                0
            ),

            Producto(
                3,
                1,
                "pizza de jamon",
                2000,
                "salsa, tomate, muzarela",
                0
            ),

            Producto(
                4,
                1,
                "pizza de muzzarela",
                2000,
                "salsa, tomate, muzzarela",
                0
            )

        )
    }

}