package Controlador


import Modelo.compras
import java.lang.Exception


class MetodoCompras {


    companion object {
        var io = ListaCompras();
        fun insertarCompra(idCompra: Number, cantidad:String,producto:String,fechaCompra: String, usuario: String, cedula: String, valorTotal: Double) {
            var ins=compras(idCompra,producto,cantidad,fechaCompra,usuario,cedula,valorTotal);
            io.escribirArchivo(ins.toString(), "listaCompras.txt");
        }

        fun crearIndice(): Number {
            var i = io.escribirArchivoIndice();
            return i;
        }

        fun leer(): List<String> {
            var listacompras:List<String> = emptyList()
            try {
                listacompras=io.LeerArchivo("src/Archivos/" + "listaCompras.txt");
                return listacompras;
            }catch(e:Exception){
                return  listacompras;
            }

        }

        fun eliminar(indice: Number) {
            io.eliminarTuplaArchivo(indice);
        }

        fun actualizar(idCompra: Number, producto:String,cantidad:String,fechaCompra: String,usuario: String, cedula: String,valorTotal: Double) {
            var ins=compras (idCompra,producto,cantidad,fechaCompra,usuario,cedula,valorTotal);
            io.actualizarTuplaArchivo(ins.toString());
        }
    }
}