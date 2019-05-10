package Controlador

import Modelo.compras

import java.io.*
import javax.swing.JOptionPane
import java.io.BufferedReader
import java.io.IOException
import java.io.FileNotFoundException


class ListaCompras {

    constructor(){

    }

    public fun escribirArchivoObjeto(objeto:compras,nombreArchivo:String):Unit{
        var fos =FileOutputStream("src/Archivos/"+nombreArchivo+".lista");
        var ous =ObjectOutputStream(fos);
        ous.writeObject(objeto);
        ous.close();

        JOptionPane.showMessageDialog(null,"Accion ejecutada con Exito!");
    }

    public fun leerArchivoObjeto(nombreArchivo: String):Any{
        var o:Any;

        var fis=FileInputStream("src/Archivos/"+nombreArchivo);
        var ois=ObjectInputStream(fis);
        o=ois.readObject();
        ois.close();

        return o;
    }

    public fun escribirArchivo(tupla:String,nombreArchivo: String){
        var bw:BufferedWriter;
        var fw:FileWriter;

        var file:File= File("src/Archivos/"+nombreArchivo);

        if(!file.exists()){
            file.createNewFile();
        }

        fw= FileWriter(file.absoluteFile,true);
        bw= BufferedWriter(fw);


        bw.write(tupla+"\n");


        if (bw != null){
            bw.close();
        }

        if (fw != null){
            fw.close();
        }

    }


    public fun escribirArchivoIndice():Number{
        var bw:BufferedWriter;
        var fw:FileWriter;

        var file:File= File("src/Archivos/index.txt");
        var i=0;
        var bandera=file.exists();
        if(!bandera){
            file.createNewFile();
        }

        fw= FileWriter(file.absoluteFile,true);
        bw= BufferedWriter(fw);
        if(!bandera){
            bw.write(i.toString()+"\n");
        }else{

            var aux=LeerArchivo("src/Archivos/indice.txt");
            var aux2= aux.get(aux.size-1).toString().toInt();
            i=aux2+1;
            bw.write(i.toString()+"\n")

        }


        if (bw != null){
            bw.close();
        }

        if (fw != null){
            fw.close();
        }

        return i;
    }


    @Throws(FileNotFoundException::class, IOException::class)
    public fun leerTxt(ruta: String): List<String> {
        var cadena: String

        var file = File(ruta);
        var fr=FileReader(file)
        val br = BufferedReader(fr);

        val l : MutableList<String> = ArrayList()

        println(br.readLine());
        var fin:Boolean=false;
        while(fin!=true){
            if(br.readLine()!=null){
                l.add(br.readLine());
            }else{
                fin=true;
            }

        }


        br.close()
        return l;
    }


    fun Leerlinea(fileName: String)
            = File(fileName).forEachLine { println(it) }


    fun LeerArchivo(fileName: String): List<String>
            = File(fileName).useLines { it.toList() }


    fun eliminarTuplaArchivo(indice:Number){
        var listaAux=LeerArchivo("src/Archivos/listaCompras.txt");

        var file = File("src/Archivos/listaCompras.txt");

        if(file.exists()){
            file.delete();

            listaAux.forEach {
                var aux=it.split(',');
                if(aux[0]!=indice.toString()){
                    escribirArchivo(it,"listaCompras.txt")
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"ATENCIÓN: No existe algún registro que borrar!");
        }
    }


    fun actualizarTuplaArchivo(ins:String){
        var listaAux=LeerArchivo("src/Archivos/listaCompras.txt");
        var indiceaux=ins.split(',');
        var file = File("src/Archivos/listaCompras.txt");

        if(file.exists()){
            file.delete();

            listaAux.forEach {
                var aux=it.split(',');
                if(aux[0]==indiceaux[0]){
                    escribirArchivo(ins,"listaCompras.txt");
                }else{
                    escribirArchivo(it,"listaCompras.txt");

                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"ATENCIÓN: Registro Inexistente!");
        }
    }
}