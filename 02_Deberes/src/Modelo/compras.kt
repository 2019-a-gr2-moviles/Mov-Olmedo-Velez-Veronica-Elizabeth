package Modelo


import java.io.Serializable

class compras : Serializable {

    var idCompra: Number=0
    var producto: String="";
    var cantidad: String="";
    var fechaCompra: String="";
    var usuario: String="";
    var cedula: String="";
    var valorTotal: Double=0.0;

    constructor(idCompra: Number, producto: String,cantidad:String,fechaCompra: String, usuario: String, cedula: String,valorTotal: Double)
    {
        this.idCompra = idCompra
        this.producto = producto
        this.cantidad = cantidad
        this.fechaCompra = fechaCompra
        this.usuario = usuario
        this.cedula = cedula
        this.valorTotal = valorTotal
    }

    override fun toString(): String {
        return this.idCompra.toString()+","+this.producto+","+this.cantidad+","+this.fechaCompra+","+this.usuario+","+this.cedula+","+this.valorTotal;
    }
}