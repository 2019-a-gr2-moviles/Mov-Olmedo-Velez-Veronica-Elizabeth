package Modelo

import java.io.Serializable

class maquillaje: Serializable{

    var id:Number=0;
    var producto:String="";
    var color:String="";
    var marca:String="";
    var precio:String="";
    var existencias:Int=0;

    constructor(id:Number,producto:String,color:String,marca:String,precio:String,existencias:Int){
        this.id=id;
        this.producto=producto;
        this.color=color;
        this.marca=marca;
        this.precio=precio;
        this.existencias=existencias;
    }

    override fun toString(): String {
        return this.id.toString()+","+this.producto+","+this.color+","+this.marca+","+this.precio+","+this.existencias;
    }

}