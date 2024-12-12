import java.util.Scanner;

public class ConvertirMoneda {

    // Función para realizar la conversión con manejo de errores y entradas válidas
    public static void realizarConversion(ConsultarMoneda consultarMoneda, String monedaOrigen, String monedaDestino, double cantidad) {
        Moneda moneda = consultarMoneda.obtenerMoneda(monedaOrigen, monedaDestino, cantidad);

        // Verifica si la respuesta es nula (error en la consulta)
        if (moneda == null) {
            System.out.println("Error al obtener el resultado de la conversión. Intenta nuevamente.");
        } else {
            System.out.println("El valor " + cantidad + " [" + monedaOrigen + "] corresponde al valor final de =>> " + moneda.conversion_result() + " [" + monedaDestino + "]\n");
        }
    }

    // Función para convertir a otra moneda
    public static void convertirOtraMoneda(ConsultarMoneda consultarMoneda, Scanner teclado, double cantidad) {
        String monedaBase;
        String monedaDestino;
        int intentosConsulta = 0; // Contador para la cantidad de intentos de la consulta

        // Bucle para permitir varios intentos de la consulta
        while (intentosConsulta < 3) {
            // Primero se pide el código de la moneda base
            monedaBase = pedirCodigoMoneda(teclado, "Ingrese el código de la moneda a convertir: ");

            // Si se supera el número de intentos de moneda, regresa al menú principal
            if (monedaBase == null) {
                return;
            }

            // Ahora se pide el código de la moneda destino
            monedaDestino = pedirCodigoMoneda(teclado, "Ingrese el código de la moneda a obtener: ");

            // Si se supera el número de intentos de moneda, regresa al menú principal
            if (monedaDestino == null) {
                return;
            }

            // Realiza la conversión
            Moneda moneda = consultarMoneda.obtenerMoneda(monedaBase, monedaDestino, cantidad);

            // Si la conversión fue exitosa, muestra el resultado y termina el bucle
            if (moneda != null) {
                realizarConversion(consultarMoneda, monedaBase, monedaDestino, cantidad);
                break;
            } else {
                // Muestra el mensaje común después de cada intento fallido
                System.out.println("Hubo un error con los códigos de moneda proporcionados. Intenta nuevamente.");

                intentosConsulta++;  // Incrementa el contador de intentos de la consulta
            }
        }

        // Si se superan los 3 intentos de la consulta, regresa al menú principal
        if (intentosConsulta >= 3) {
            System.out.println("Has alcanzado el número máximo de intentos (3) para la consulta. Volviendo al menú principal.");
        }
    }

    // Función para pedir y validar el código de la moneda
    private static String pedirCodigoMoneda(Scanner teclado, String mensaje) {
        String codigoMoneda;
        int intentos = 0;  // Contador de intentos fallidos

        while (intentos < 3) {  // Permitimos hasta 3 intentos
            System.out.print(mensaje);
            codigoMoneda = teclado.nextLine().toUpperCase().trim(); // Convierte a mayúsculas y elimina espacios extra

            // Verifica que el código sea válido (3 caracteres alfabéticos)
            if (codigoMoneda.matches("[A-Z]{3}")) {
                return codigoMoneda;  // Si el código es válido, lo devuelve
            } else {
                System.out.println("Error: El código de moneda debe ser una cadena de 3 letras.");
                intentos++;  // Aumenta el contador de intentos
            }
        }

        // Si el usuario llega a 3 intentos fallidos, retornamos null
        System.out.println("Has alcanzado el número máximo de intentos (3). Volviendo al menú principal.");
        return null;  // Regresa null para que el flujo principal sepa que debe regresar al menú
    }
}