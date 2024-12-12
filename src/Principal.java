import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultarMoneda consultarMoneda = new ConsultarMoneda();

        String mensaje = """
                ***********************************************
                Sea bienvenido/a al Conversor de Moneda
                
                1. Dólar (USD) a Peso Argentino (ARS)
                2. Peso Argentino (ARS) a Dólar (USD)
                3. Dólar (USD) a Real Brasileño (BRL)
                4. Real Brasileño (BRL) a Dólar (USD)
                5. Dólar (USD) a Peso Colombiano (COP)
                6. Peso Colombiano (COP) a Dólar (USD)
                7. Convertir otra moneda
                8. Salir
                ***********************************************
                """;

        int op;
        double cantidadIngresada;

        do {
            System.out.println(mensaje);
            System.out.print("Elija una opción: ");
            op = obtenerOpcionValida(teclado);

            if (op == 8) {
                System.out.println("Finalizando el programa...");
                break;
            }

            System.out.print("Ingrese valor a convertir: ");
            cantidadIngresada = obtenerCantidadValida(teclado);

            switch (op) {
                case 1:
                    ConvertirMoneda.realizarConversion(consultarMoneda, "USD", "ARS", cantidadIngresada);
                    break;
                case 2:
                    ConvertirMoneda.realizarConversion(consultarMoneda, "ARS", "USD", cantidadIngresada);
                    break;
                case 3:
                    ConvertirMoneda.realizarConversion(consultarMoneda, "USD", "BRL", cantidadIngresada);
                    break;
                case 4:
                    ConvertirMoneda.realizarConversion(consultarMoneda, "BRL", "USD", cantidadIngresada);
                    break;
                case 5:
                    ConvertirMoneda.realizarConversion(consultarMoneda, "USD", "COP", cantidadIngresada);
                    break;
                case 6:
                    ConvertirMoneda.realizarConversion(consultarMoneda, "COP", "USD", cantidadIngresada);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consultarMoneda, teclado, cantidadIngresada);
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            // Preguntar si desea hacer otra consulta, con validación de la respuesta
            String opc;
            do {
                System.out.print("¿Desea hacer otra consulta? (Si/No): ");
                opc = teclado.nextLine().trim(); // Uso trim() para limpiar los espacios al principio y final

                // Convertir la respuesta a minúsculas para evitar problemas de mayúsculas/minúsculas
                if (opc.equalsIgnoreCase("Si") || opc.equalsIgnoreCase("No")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese 'Si' o 'No'.");
                }
            } while (true);

            if (opc.equalsIgnoreCase("No")) {
                System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                break;
            }

        } while (true);

        teclado.close();
    }

    private static int obtenerOpcionValida(Scanner teclado) {
        int op;
        while (true) {
            String input = teclado.nextLine().trim();

            try {
                op = Integer.parseInt(input);  // Intenta convertir la entrada a un entero
                if (op >= 1 && op <= 8) {
                    break;  // Si la conversión es exitosa y la opción es válida, sale del bucle
                } else {
                    System.out.print("Por favor, ingrese una opción válida (1-8): ");
                }
            } catch (NumberFormatException e) {
                // Si no es un número válido, muestra un mensaje de error
                System.out.print("Por favor ingrese un número válido: ");
            }
        }
        return op;
    }

    private static double obtenerCantidadValida(Scanner teclado) {
        double cantidad;
        while (true) {
            String input = teclado.nextLine().trim();

            try {
                cantidad = Double.parseDouble(input);  // Intenta convertir la cadena a un número decimal
                if (cantidad >= 1) {
                    break;  // Si la conversión es exitosa y la cantidad es válida, sale del bucle
                } else {
                    System.out.print("Por favor ingrese un valor mayor a cero: ");
                }
            } catch (NumberFormatException e) {
                // Si no es un número válido, se muestra un mensaje de error
                System.out.print("Por favor ingrese un valor numérico válido: ");
            }
        }
        return cantidad;
    }
}