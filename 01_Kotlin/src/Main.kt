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

    //nombre = "Veronica"

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

}

 // Funciones

fun estaJalado (nota:Double){
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
}