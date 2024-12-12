import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultarMoneda {

    private static String obtenerApiKey() {
        // Ruta del archivo config.properties
        String filePath = "config/config.properties";

        // Crear objeto Properties para cargar el archivo
        Properties prop = new Properties();

        try (FileInputStream input = new FileInputStream(filePath)) {
            prop.load(input);

            // Obtiene la clave API desde el archivo de propiedades
            String apiKey = prop.getProperty("api.key");

            if (apiKey == null || apiKey.isEmpty()) {
                throw new RuntimeException("La clave de API no está configurada en el archivo config.properties.");
            }

            return apiKey;

        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de configuración: " + ex.getMessage());
            throw new RuntimeException("No se pudo cargar el archivo de configuración.");
        }
    }

    public Moneda obtenerMoneda(String monedaBase, String monedaDestino, double cantidadIngresada) {
        // Obteniendo la clave de la API desde el archivo de configuración
        String apiKey = obtenerApiKey();

        // Construyendo la URL con la clave de API de forma segura
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                + monedaBase + "/" + monedaDestino + "/" + cantidadIngresada);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Si la respuesta de la API es exitosa (código 200)
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Moneda moneda = gson.fromJson(response.body(), Moneda.class);

                // Verifica que la respuesta contenga un resultado válido
                if (moneda.conversion_result() != 0) {
                    return moneda;
                } else {
                    System.out.println("Error: No se obtuvo un resultado válido de la API.");
                    return null;
                }
            } else {
                // Si la respuesta no es exitosa, se muestra un mensaje adecuado
                System.out.println("Error en la respuesta de la API: Código " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            // Captura cualquier excepción y muestra un mensaje más amigable
            System.out.println("Hubo un error al realizar la consulta. Asegúrate de que los códigos de moneda sean correctos.");
            return null;
        }
    }
}

