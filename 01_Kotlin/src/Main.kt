
import java.util.*


fun main (args: Array <String>){
    // Comentarios

    //Variables
    // Que es mutar?? cambiar??

    // Mutables

    var nombreI = "Elizabeth"
    nombreI = "Karen"

    // Inmutables
    /* No se puede cambiartodo lo que se pueda hacer inmotable es mejor
     Mientras mas inmutable sea el codigo es mejor*/


    val nombre = "Veronica"
    // nombre = "Veronica"

    // Tipos de Datos

    val apellido: String ="Olmedo"
    val edad: Int = 24
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val profesor: Boolean = true
    val hijos: Nothing? = null

    // Duck Typing ingiere el tipo de dato automaticamente
    // Si parece un pato
    // Si camina como pato
    // Si suena como pato
    // Si vuela como pato
    // PATO

    // Condicional

    if (apellido == "Olmedo" || nombre == "Veronica"){
        println( "Verdadero")
    }else {
        println("Falso")
    }

    val tieneNombreYApellido = if(apellido!=null && nombre!=null) "ok" else "no"
    println (tieneNombreYApellido)


    estaJalado( 1.0)
    estaJalado( 8.0)
    estaJalado( 0.0)
    estaJalado( 7.0)
    estaJalado( 10.0)
    holaMundo("Veronica")
    holaMundo(2)
     //No se necesita escribir las numUno y numDos los pone el editor de texto

    val total = sumarDosNumeros(1,2)
    println (total)

    val arregloCumpleano: Array<Int> = arrayOf(1, 2, 3, 4)
    var arregloTodo: Array<Any> = arrayOf (1, "feliz",2.0,true) // Se debe cambiar a var para hacer la variable mutable

    arregloCumpleano[0]=5
    arregloCumpleano.set (0,5) // La variable se cambio

    arregloTodo= arrayOf(5, 2, 3, 4) // La variable es inmutable es no reasignable

    // val nota: ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5,6) No es necesario por es Duck Typing

    val nota = arrayListOf(1,2,3,4,5,6)


    val numerito = Numero(1)

    // forEach -> Iterar el arreglo

    nota.forEach {nota: Int ->
        println(nota)
    }

    nota.forEachIndexed { indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")
        //return Unit
    }

    // MAP -> Itera y modifica el arreglo
    // Sumar a los Impares +1 Pares +2
    val notasDos = nota.map { notas ->
        notas + 1
    }

    val notasTres = nota.map { notas ->
        val modulo = notas % 2
        val esPar = 0
        when (modulo){
            esPar -> {
                notas + 1
            }
            else -> {
                notas + 2
            }
        }
    }

    notasDos.forEach {
        println("Notas 2: $it")
    }


    notasTres.forEach {
        println("Notas 3: $it")
    }

    val respuestaFilter = nota.filter{// Filtrar el arreglo
        it < 5 && it > 2
        //it in 3..4 // rango
    }
        .map {  //Mutar o cambiar el arreglo
            it * 2
        } //Concatenarlo si la respuesta es un array
    respuestaFilter.forEach { println(it)}

    val novias = arrayListOf(1, 2, 3, 4, 5)

    //Existira un elemento que sea igual a 3
    val respuestaNovia: Boolean = novias.any{//Existe algun que sea igual a 3
        it == 3
    }
    println(respuestaNovia) // true


    val tazos = arrayListOf (1, 2, 3, 4, 5, 6, 7)

    val respuestaTazos = tazos.all{
        it > 1
    }

    println(respuestaTazos) // Tazos


    val totalTazos = tazos.reduce {valorAcumulado, tazo ->
        valorAcumulado + tazo
    } //Tiene un valor acumulado de inicio = 0 se puede hacer cualquier operacion


    println(totalTazos)


    val fecha = Date()
    fecha.time = 11234566
    fecha.year = 200
    //fecha = Date (1989,6,10)

}

 // Funciones

fun estaJalado (nota:Double): Double {
    when (nota){
        0.0 -> {
            println ("Dios mio que vago")
        }
        7.0 -> {
            println("Pasaste con las justas")
        }
        10.0 -> {
            println("Genial :D Felicitaciones")
        }
        else -> {
            println ("Tu nota es : $nota")
            // println ("Tu nota es : ${nota}")
        }

    }
    return nota
}

fun holaMundo( mensaje:String): Unit{
    println("Mensaje : $mensaje.") // El void de kotlin es unit
}
fun holaMundo( mensaje: Any) : Unit{
    println("Mensaje : $mensaje.") // Any cualquier cosa
}
fun sumarDosNumeros( numUno: Int, numDos: Int) : Int{
    return numUno + numDos                             // Sumar dos numeros
}

//Clases en Kotlin
//Palabra reservada




class Usuario(var cedula:String) { //Primer constructor
    public var nombre: String = "" // Inicializar
    public var apellido: String = "";

    /*constructor (
        cedulaM: String,
        apellido: String):this.(cedulaM)// tambien se puede inicializar en el constructor

    {
        this.apellido = apellido/
    }
     */
    }

//Se puede utilizar varios constructores
// No se debe utilizar get y set
// Por defecto todas las propiedades por defecto son publicas


    class UsuarioKT(
        public var nombre: String,
        public val apellido: String, private var id: Int,
        protected var id2: Int) {

        init {

        }

        public fun hola(): String {
            return this.apellido
        }

        private fun hola2() {

        }

        protected fun hola3() {

        }

        //No tiene metodos estaticos y tmpoco sw

        companion object {
            val gravedad = 10.5
            fun correr() {
                println("Estoy corriendo en $gravedad")
            }
        }
    }

    class BaseDeDatos {
        companion object {
            val usuarios = arrayListOf(1, 2, 3)
            fun agregarUsuario(usuario: Int) {
                this.usuarios.add(usuario)
            }

            fun eliminarUsuario(usuario: Int) {
                //this.usuarios
            }

        }
    }


    fun aa() {
        UsuarioKT.gravedad // Son parecido a las propiedades estaticas
        UsuarioKT.correr() // Son parecidos a los metodos staticos en java
    }


    fun a() {
        val nika = UsuarioKT("a", "b", 1)
        nika.nombre = "Eli"
    }

    fun UsuarioKT(nombre: String, apellido: String, id: Int) {

    }

    //Sobrecarga de constructores distintos tipos de parametos
    class Numero(var numero: Int) {

        constructor(numeroString: String) : this(numeroString.toInt()) {
            println("CONSTRIUCTOR")
        }

        init {
            println("INIT")
        }
    }

    class A {}

//A.corre()   //Metodo estatico
//A.gravedad  //Propiedad estatica

}

open class  Numeros(var numeroUno: Int, var numeroDos: Int){

}

final class Suma (var numeroUnos:Int,
            var numeroDoss:Int):
            Numeros(numeroUnos,numeroDoss){
    }

fun cc(){
    val a = Suma(1,2)
}











fun  presley(requerido:Int,
             opcional:Int=1,
             nulo:Usuario.UsuarioKT?){ // A veces va a ser nulo
        //nulo.nombre  //Puede ser nulo
    if(nulo != null)
        nulo.nombre

    val nombresito:String? = nulo?.nombre.toString()//Un estrig que a veces es nulo y a veces es string
    nulo!!.nombre //La variable
}

fun cddd(){
    presley(requerido=1, nulo= null) // Named Parameters
    presley(1,1,null)
    presley(1,1,null)
}
