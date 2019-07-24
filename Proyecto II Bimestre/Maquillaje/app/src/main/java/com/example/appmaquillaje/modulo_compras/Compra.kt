package com.example.appmaquillaje.modulo_compras

import com.example.appmaquillaje.clases_auxiliares.ClienteAux
import com.example.appmaquillaje.clases_auxiliares.ProductoAux

class Compra(
    var id: Int?,
    var fecha: String?,
    var cantidad: Int?,
    var total: Double?,
    var validez: Boolean?,
    var codigoCli: ClienteAux?,
    var codigoProd: ProductoAux?
) {

}