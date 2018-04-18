fun sumarDosNumeros(numeroUno: Int, numeroDos: Int): Int {
    return numeroUno + numeroDos
}

fun main(args: Array<String>) {
    println("Hola, mundo!") //System.out.
    println(sumarDosNumeros(1, 2))//3
    //no puede ser null
    var nombre: String = "Adrian"
    //puede ser null
    var nombre2: String? = "Adrian2"
    nombre2 = null

    var edad: Int = 28
    //constante
    val edadActual = 28
    var casado = false
    casado = true
    //duck typing
    //edadActual = 29 //error xq val es constante
    //tipo switch
    when (casado) {
        true -> {
            println("Esta casado")
        }
        null -> {
            println("No esta asignado")
        }
        else -> {
            println("No esta casado")
        }
    }

    val superHeroe = if (casado) {
        "SuperMandarina"
    } else {
        "Superman"
    }
    println("Superheroe: " + superHeroe)
    //template strings
    println("Superheroe: $superHeroe")

    var darwin = Persona(Integer(21), "Darwin")
    println(darwin.toString())
    var persona2 = PersonaDos(Integer(21), "Pers 2", "1724")
    println(persona2)
    var persona3 = PersonaTres(Integer(50), "Pers 3")
    println(persona3)
    var cuadrado = Cuadrado("Cuadrado", Integer(50))
    println(cuadrado)
}

//por defecto publica
class Persona {
    //mas luego la iniciamos
    lateinit var edadActual: Integer
    var nNombre: String

    //constructor(edad:Any){
//    constructor(edad:Integer){
//    edadActual = edad
//    }
    constructor(edad: Integer, nombre: String) {
        iniciar(edad)
        nNombre = nombre
    }

    fun iniciar(edad: Integer) {
        edadActual = edad
    }

    override fun toString(): String {
        return "La edad actual es $edadActual y el nombre es $nNombre"
    }
}

//este constructor se ejecuta primero que el interno
class PersonaDos constructor(edad: Integer, nombre: String) {
    var nEdad = edad
    var nNombre = nombre
    var nCedula: String? = null
    var nCasado: Boolean? = null

    constructor(edad: Integer, nombre: String, cedula2: String) : this(edad, nombre) {
        //no requerido
        nCedula = cedula2
    }

    constructor(edad: Integer, nombre: String, cedula2: String, casado: Boolean) : this(edad, nombre) {
        //no requerido
        nCedula = cedula2
        nCasado = casado
    }

    override fun toString(): String {
        if (nCedula == null && nCasado == null)
            return "P2 La edad actual es $nEdad y el nombre es $nNombre"
        else if (nCedula == null && nCasado!=null)
            return "P2 La edad actual es $nEdad y el nombre es $nNombre y casado = $nCasado"
        else if (nCedula != null && nCasado==null)
            return "P2 La edad actual es $nEdad y el nombre es $nNombre y cedula = $nCedula"
        else
            return "P2 La edad actual es $nEdad y el nombre es $nNombre y casado = $nCasado y cedula = $nCedula"
    }
}


class PersonaTres constructor(edad: Integer, nombre: String) {
    lateinit var nEdad: Integer
    var nNombre = nombre
    var nCedula: String? = null
    var nCasado: Boolean? = null

    init {
        //codigo despues del constructor
        iniciar(edad)
    }

    fun iniciar(edad: Integer) {
        nEdad = edad
    }

    override fun toString(): String {
        return "P3 La edad actual es $nEdad y el nombre es $nNombre"
    }
}

//con open hacemos q no sea final
open class Figura(nombre: String) {
    val nNombre = nombre
}

class Cuadrado(nombre: String, valorLado: Integer) : Figura(nombre) {
    var nValorLado = valorLado
    override fun toString(): String {
        return "Nombre = $nNombre y Lado = $nValorLado"
    }
}