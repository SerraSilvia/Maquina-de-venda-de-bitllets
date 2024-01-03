import org.example.BLUE_BOLD
import org.example.CYAN_BOLD
import org.example.RESET
import kotlin.math.abs

fun main() {

    while (true) {
        printAsciiArt()
        // Estado inicial
        var seguirComprant = "n".lowercase()
        var exist = false
        var preuTotalBitllets = 0.0

        val paraulaSeguretat = 4321

        do {
            val (opcio, preu) = opcioBitllet()

            if (opcio != 6) {
                val (preuPerBitllet, zona) = zonaBitllet(preu)
                val detall = "Opció: $opcio, Zona: $zona - Preu: $preuPerBitllet €"
                detallsCompra.add(detall)

                preuTotalBitllets += quantitatBitllets(preuPerBitllet)

                println("Ha escollit la opció: $opcio, zona $zona ")
                println("El preu del bitllet és de: $preuPerBitllet €")
                println("El preu total dels bitllets és de: $preuTotalBitllets €")
            }

            if (seguirComprant == "n") {
                exist = true
                gestionarCompra(preuTotalBitllets)
                imprimirTiquet(preuTotalBitllets)
            }

        } while (opcio != 6 && opcio != paraulaSeguretat && !exist)

        println("Fi de compra. Tornant a l'estat inicial.")
    }
}



