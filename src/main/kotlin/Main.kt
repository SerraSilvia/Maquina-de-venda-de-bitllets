import org.example.BLUE_BOLD
import org.example.RESET

/**
 * És una funció de benvinguda al programa amb un ascii art
 * @author Sivia Serra
 * @since 31/12/2023
 * @param asciiArt Dibuix de les sigles de TMB i FGC
 * Es fa servir lús de colors per tenir una millor visualització de l'inici
 * @see trimIndent()
 * La funció trimIndent() s'encarrega d'eliminar els espais en blanc als marges d'un bloc de text sense afectar el contingut real del text.
 * @return Benvinguda al programa
 */
fun printAsciiArt(){
    val asciiArt= """   $BLUE_BOLD
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
 * És una funció que permet escollir el tipus de bitllet desitjat
 * @author Sivia Serra
 * @since 31/12/2023
 * @param opcio L'usuari escull la opció desitjada
 * @return Opció triada
 */
fun opcioBitllet(opcio:Int):Int{
    when (opcio){
            1-> println("Bitllet senzill")
            2-> println("TCasual")
            3-> println("TUsual")
            4-> println("TFamiliar")
            5-> println("TJove")
            6-> println("Sortir")
    }
    return opcio
}

fun main() {
        printAsciiArt()
        println("$BLUE_BOLD \n Escull el número de l' opció desitjada: $RESET")
    val paraulaSeguretat = 4321

    do {
        val opcio= readln().toInt()
        println(opcioBitllet(opcio))

    }while (opcio != 6 && opcio != paraulaSeguretat)
}