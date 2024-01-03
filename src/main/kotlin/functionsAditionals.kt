import org.example.BLUE_BOLD
import org.example.CYAN_BOLD
import org.example.RESET
import kotlin.math.abs

/**
 * És una funció de benvinguda al programa amb un ascii art
 * @author Sivia Serra
 * @since 31/12/2023
 * Es fa servir lús de colors per tenir una millor visualització de l'inici
 * @see trimIndent()
 * La funció trimIndent() s'encarrega d'eliminar els espais en blanc als marges d'un bloc de text sense afectar el contingut real del text.
 * @return Benvinguda al programa
 */
fun printAsciiArt(){
    val asciiArt= """   $CYAN_BOLD
        *************************************************
        *  BENVINGUTS A LA XARXA DE TRANSPORTS DE BCN   *
        * _____ __  __ ____            _____ ____  ____ *
        *|_   _|  \/  | __ )          |  ___/ ___|/ ___|*
        *  | | | |\/| |  _ \   _____  | |_ | |  _| |    *
        *  | | | |  | | |_) | |_____| |  _|| |_| | |___ *
        *  |_| |_|  |_|____/          |_|   \____|\____|*
        ************************************************* $RESET
    """.trimIndent()
    println(asciiArt)
}



/**
 * És una funció que permet escollir el tipus de bitllet desitjat amb el seu preu
 * @author Sivia Serra
 * @since 31/12/2023
 * @return Opció triada
 */
fun opcioBitllet(): Pair<Int, Double> {
    println("1.- Bitllet senzill....2.40€ (1a zona)")
    println("2.- TCasual............11.35€ (1a zona)")
    println("3.- TUsual.............40.00€ (1a zona)")
    println("4.- TFamiliar..........10.00€ (1a zona)")
    println("5.- TJove..............80.00€ (1a zona)")
    println("6.- Sortir")
    println("$BLUE_BOLD \n Quin bitllet desitja adquirir? $RESET")

    var opcio: Int

    do {
        opcio = readln().toInt()

        if (opcio > 6 || opcio < 1)
            println("Escull un tipus de bitllet vàlid")

    } while(opcio > 6 || opcio < 1)

    val preu = preuTipusBitllet(opcio)

    return Pair(opcio, preu)

}


/**
 * És una funció que dona preu al bitllet
 * @author Sivia Serra
 * @since 31/12/2023
 * @return Opció triada
 */
fun preuTipusBitllet (tipusBitllet: Int): Double {
    return when (tipusBitllet){
        1-> 2.40
        2-> 11.35
        3-> 40.00
        4-> 10.00
        5-> 80.00
        else-> 0.0
    }
}
/**
 * És una funció que permet escollirla zona a viatjar
 * @author Sivia Serra
 * @since 31/12/2023
 * @return Opció triada
 */
fun zonaBitllet (preu: Double): Pair <Double, Int> {
    println("$BLUE_BOLD Quina zona vol viatjar?  $RESET")

    var zona: Int

    do {
        zona = readln().toInt()

        if (zona > 4 || zona < 1)
            println("Selecciona una zona vàlida")

    }while(zona > 4 || zona < 1)

    return Pair(when(zona) {
        2 -> preu * 1.3125
        3 -> preu * 1.8443
        else -> preu
    }, zona)
}
/**
 * És una funció que permet escollir la quantitat de bitllets i calcular el preu
 * @author Sivia Serra
 * @since 31/12/2023
 * @see abs et retorna els negatius en positiu i fa el càlcul en positiu
 * @return preu total
 */
fun quantitatBitllets (preuPerBitllet: Double): Double {
    println("$BLUE_BOLD Ingressi el nombre de bitllets  $RESET")

    val nombreBitllets = abs(readln().toInt())// abs te devuelve el valor absoluto

    return (preuPerBitllet * nombreBitllets)
}

/**
 * Función que gestiona la compra de billetes, pagos y cambio.
 * @param totalCompra El monto total a pagar.
 */
fun gestionarCompra(totalCompra: Double) {
    var cantidadPagada = 0.0
    var cambio: Double
    val restaPagar = totalCompra - cantidadPagada
    println("Vols seguir comprant? [S,N]")
    var seguirComprando = readln().lowercase()

    while (seguirComprando == "s") {
        println("Introdueixi monedes o billets, recordi, si us plau, aquesta màquina només accepta monedes de: 0.01€, 0.02€, 0.05€, 0.10€, 0.20€, 0.50€, 1€, 2€. I bitllets de 5€, 10€, 15€, 20€, 50€")
        val cantidadIntroducida = readln().toDouble()

        cantidadPagada += cantidadIntroducida
        val restaPagar = totalCompra - cantidadPagada

        println("Ha introduït $cantidadIntroducida€. Li resta pagar $restaPagar€.")

        if (restaPagar <= 0) {
            cambio = cantidadPagada - totalCompra
            println("Ha pagat l'import total. El seu canvi és de $cambio€.")
            break
        }

        println("Vols introduir més monedes o bitllets? [S,N]")
        seguirComprando = readln().lowercase()
    }

    if (seguirComprando == "n") {
        val cantidadBilletsComprats = (totalCompra / preuTipusBitllet(1)).toInt()
        println("Ha comprat $cantidadBilletsComprats bitllet(s). Ha de pagar $totalCompra€.")

        if (cantidadPagada >= totalCompra) {
            cambio = cantidadPagada - totalCompra
            println("Ha pagat l'import total. El seu canvi és de $cambio€.")
        } else {
            println("El pagament no és suficient. Faltant $restaPagar€.")
        }
    }
}
