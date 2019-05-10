package Controlador

import Modelo.maquillaje;
import java.lang.Exception



class MetodosMaquillaje {



    companion object {
        var io = ListaMaquillaje();
        fun insertar(id:Number,producto:String,color:String,marca:String,precio:String,existencias:Int) {
            var ins=maquillaje(id,producto,color,marca,precio,existencias);
            io.escribirArchivo(ins.toString(), "listaMaquillaje.txt");
        }

        fun crearIndex(): Number {
            var i = io.escribirArchivoIndex();
            return i;
        }

        fun leer(): List<String> {
            var listamaquillajes:List<String> = emptyList()
            try {
                listamaquillajes=io.LeerArchivo("src/Archivos/" + "listaMaquillaje.txt");
                return listamaquillajes;
            }catch(e:Exception){
                return  listamaquillajes;
            }


        }

        fun eliminar(index: Number) {
            io.eliminarTuplaArchivo(index);
        }

        fun actualizar(id:Number,producto:String,color: String,marca: String,precio: String, existencias:Int) {
            var ins=maquillaje(id,producto,color,marca,precio, existencias);
            io.actualizarTuplaArchivo(ins.toString());
        }
    }
}