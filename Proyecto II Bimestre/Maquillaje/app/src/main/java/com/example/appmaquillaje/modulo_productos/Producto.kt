package com.example.appmaquillaje.modulo_productos

class Producto(

    var createdAt: Long?,
    var updatedAt: Long?,
    var id: Int?,
    var marca: String,
    var color: String,
    var existencias: Int,
    var tipo: String,
    var cantidad: Int,
    var precio: Double
) {

}