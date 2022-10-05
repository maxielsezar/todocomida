package com.desarrolloswesquel.todocomida.modelo.carga


import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.modelo.Local

class CargarLocal {

    fun listaLocales(): List<Local> {
        return listOf(
            Local(
                0,
                "La Luna",
                "Restaurant",
                "Av. Fontana 656",
                R.drawable.images,
                -42.9123190441055,
                -71.3192489142523
            ),

            Local(
                1,
                "Maria Castaña",
                "Confiteria",
                "25 de Mayo y Rivadavia",
                R.drawable.image1,
                -42.914147032096416,
                -71.32062964495022
            ),

            Local(
                2,
                "La Barra",
                "Parrilla",
                "Sarmiento 638",
                R.drawable.image2,
                -42.913285828706975,
                -71.32012894038876
            ),

            Local(
                3,
                "Plan B",
                "Cerveceria",
                "25 de Mayo 460",
                R.drawable.image3,
                -42.91533456031436,
                -71.31924518341688
            ),

            Local(
                4,
                "Rider",
                "Cerveceria",
                "25 de Mayo 478",
                R.drawable.image4,
                -42.91523244891188,
                -71.3193618924102
            ),

            Local(
                5,
                "Otto Beer",
                "Cerveceria",
                "Av. Alvear 975",
                R.drawable.image5,
                -42.913085975769526,
                -71.32288044620171
            ),

            Local(
                6,
                "Blest",
                "Cerveceria",
                "Av. Alvear 1025",
                R.drawable.image6,
                -42.9125636900323,
                -71.32223939265208
            ),

            Local(
                7,
                "Vascongada",
                "Restaurant",
                "9 de Julio y Mitre",
                R.drawable.image7,
                -42.91589901771981,
                -71.32476795243552
            ),

            Local(
                8,
                "Ombu",
                "Cerveceria",
                "San Martín y Sarmiento",
                R.drawable.image8,
                -42.914104004214124,
                -71.31833419901687
            ),

            Local(
                9,
                "Amancay",
                "Cerveceria",
                "25 de Mayo 415",
                R.drawable.image9,
                -42.91547303678974,
                -71.31866989541302
            ),

            Local(
                10,
                "Pil Pil",
                "Restaurant",
                "Sarmiento 799",
                R.drawable.image10,
                -42.91192246060708,
                -71.32135623837537
            ),
        )
    }
}