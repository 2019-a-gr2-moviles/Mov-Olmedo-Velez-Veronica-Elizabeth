package com.example.appmaquillaje.modulo_clientes

class Cliente(
//    var compraDeCliente: ArrayList<CompraAux>?,
    var createdAt: Long?,
    var updatedAt: Long?,
    var id: Int?,
    var nombre: String,
    var apellido: String,
    var cedula: String
) {

}


//parcel.readSerializable() as? ArrayList<Compra>,
//parcel.writeSerializable(compraDeCliente)