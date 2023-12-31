import org.example.BLUE_BOLD
import org.example.CYAN_BOLD
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
        else-> println("Escriu un número vàlid")
    }
    return opcio
}

fun preusPerZona1(opcio:Int):Double{
   return when (opcio){
        1-> 2.40
        2-> 11.35
        3-> 40.00
        4-> 10.00
        5-> 80.00
        else-> 0.0
    }
}
fun preusPerZona2(opcio:Int):Double{
    return when (opcio){
        1-> 2.40*1.3125
        2-> 11.35*1.3125
        3-> 40.00*1.3125
        4-> 10.00*1.3125
        5-> 80.00*1.3125
        else-> 0.0
    }
}

fun preusPerZona3(opcio:Int):Double{
    return when (opcio){
        1-> 2.40*1.8443
        2-> 11.35*1.8443
        3-> 40.00*1.8443
        4-> 10.00*1.8443
        5-> 80.00*1.8443
        else-> 0.0
    }
}

fun main() {
        printAsciiArt()
        println("$BLUE_BOLD \n Quin bitllet desitja adquirir? $RESET")
    val paraulaSeguretat = 4321
    val seguirComprant= "n".lowercase()

    do {
        val opcio= readln().toInt()
        println(opcioBitllet(opcio))

        println("$BLUE_BOLD Quina zona vol viatjar?  $RESET")
        val zona= readln().toInt()
        if (zona==1){
            preusPerZona1(opcio)
        }else if (zona == 2){
            preusPerZona2(opcio)
        }else if (zona==3){
            preusPerZona3(opcio)
        }

        println("Ha escollit la opció: $opcio, zona $zona ")
        println("El preu del bitllet és de: "+preusPerZona1(opcio))
        println("Vols seguir comprant? [S,N]")


    }while (opcio != 6 && opcio != paraulaSeguretat && opcio != seguirComprant)
    println("Fi de programa")
}