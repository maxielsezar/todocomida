package com.desarrolloswesquel.todocomida.modelo.carga


import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Categoria

class CargarCategoria {

    fun listaCategoria(): List<Categoria> {
        return listOf(
            Categoria(
                0,
                "Pizzas",
                R.drawable.pizza
            ),

            Categoria(
                1,
                "Burgers",
                R.drawable.hamburguesas
            ),
            Categoria(
                2,
                "Empanadas",

                R.drawable.empanada
            ),
            Categoria(
                3,
                "Pastas",
                R.drawable.pastas
            ),

            Categoria(
                4,
                "Pintas",

                R.drawable.cerveza
            ),

            Categoria(
                5,
                "Carnes",

                R.drawable.carnes
            ),

            Categoria(
                6,
                "Milanesas",

                R.drawable.milanesa
            ),

            Categoria(
                9,
                "Papas",

                R.drawable.papasfritas
            ),

            Categoria(
                7,
                "Helados",

                R.drawable.helado
            ),

            Categoria(
                8,
                "Chocolates",
                R.drawable.chocolates
            )
        )
    }
}