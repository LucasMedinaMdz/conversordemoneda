# 💱 Conversor de Moneda en Java
### Desafío Alura Latam y Oracle

Este proyecto es el resultado de un *challenge* de programación, realizado como parte de la colaboración entre Alura Latam y Oracle. El objetivo fue construir un Conversor de Monedas en Java, haciendo uso de una API externa para obtener tasas de cambio, procesando la respuesta JSON y presentando los resultados de manera interactiva para los usuarios.

## 📝 Descripción del Proyecto

El **Conversor de Monedas** permite convertir entre diversas monedas, consultando una API de tasas de cambio en tiempo real. El flujo de trabajo incluye la configuración del entorno Java, la creación del proyecto, el consumo de la API, el análisis de la respuesta JSON, el filtrado de las monedas de interés y la presentación de resultados de forma interactiva para el usuario.

### Expansión de Monedas
Actualmente, el proyecto soporta varias monedas comunes como:
- **USD** (Dólar estadounidense)
- **ARS** (Peso argentino)
- **BRL** (Real brasileño)
- **COP** (Peso colombiano)

Sin embargo, el sistema está diseñado para ser fácilmente ampliable, permitiendo consultar más monedas y ofrecer una gama aún mayor de opciones monetarias para los usuarios.

## 📚 Aprendizajes Clave

Durante el desarrollo de este proyecto, se adquirieron diversos conocimientos técnicos:

- **Consumo de APIs en Java**: Se aprendió a realizar solicitudes HTTP utilizando la librería `HttpClient` de Java, así como a manejar respuestas en formato JSON con la ayuda de la librería `Gson`.
- **Manejo de Datos JSON**: Se implementó la lógica necesaria para parsear y filtrar los datos JSON provenientes de la API de tasas de cambio.
- **Interacción con el Usuario**: Se desarrolló una interfaz de consola interactiva que permite al usuario seleccionar la moneda de origen y destino, ingresar un valor y obtener el resultado de la conversión.
- **Validación de Entradas**: Se implementaron validaciones para asegurar que el usuario ingrese opciones y cantidades válidas.

## 🚀 Requisitos

Para ejecutar este proyecto, asegúrate de tener los siguientes requisitos previos:

1. **Java JDK 11 o superior**  
   Este proyecto está desarrollado con Java JDK 21. Puedes descargar la última versión LTS (Long-Term Support) de Java desde el siguiente enlace:  
   [Descargar Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

2. **Biblioteca Gson 2.10.1 o superior**  
   Gson es la biblioteca utilizada para parsear y manejar datos en formato JSON. Para incluir Gson en tu proyecto, debes agregar la dependencia correspondiente en tu archivo `pom.xml` (si usas Maven).  
   Puedes obtener la última versión de Gson en el [Maven Central Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).

3. **API Key de ExchangeRate-API**  
   Debes obtener una clave de API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/). Regístrate, crea una cuenta (es gratuito) y obtén tu clave API personal desde el dashboard de la página. Luego, guarda tu clave en un archivo `config.properties` en el directorio raíz del proyecto.

## 🔧 Pasos Seguidos en el Proyecto

### 1. Configuración del Entorno Java
La configuración inicial del proyecto se realizó utilizando Java JDK 21. Esto permitió utilizar las librerías modernas de Java como `HttpClient` para realizar solicitudes HTTP y `Gson` para manipular datos JSON.

### 2. Estructura del Proyecto
El proyecto consta de varias clases principales que gestionan diferentes aspectos de la conversión de moneda:
- `Principal.java`: Contiene la lógica principal del programa, incluyendo la interacción con el usuario, la selección de opciones y la ejecución de las conversiones.
- `ConsultarMoneda.java`: Se encarga de realizar la solicitud a la API de tasas de cambio, procesar la respuesta y devolver los datos en un formato adecuado.
- `Moneda.java`: Un *record* que modela los datos que se reciben de la API, incluyendo la moneda de origen, destino, la tasa de conversión y el resultado final de la conversión.
- `ConvertirMoneda.java`: Contiene los métodos de conversión y permite al usuario realizar múltiples conversiones de monedas, con soporte para volver a intentar en caso de errores con los códigos de moneda ingresados.

### 3. Consumo de la API
Utilizando la clase `HttpClient` de Java, se realizan solicitudes HTTP a la API de ExchangeRate-API para obtener las tasas de cambio actualizadas. La respuesta de la API, en formato JSON, es procesada mediante `Gson` para extraer la tasa de conversión y calcular el resultado final de la conversión.

### 4. Análisis de la Respuesta JSON
La respuesta de la API está en formato JSON. Para procesarla, se utiliza `Gson` para convertir la respuesta en un objeto Java y extraer los valores necesarios, como la tasa de conversión y el resultado final. Además, se implementan validaciones para asegurarse de que la respuesta sea correcta y que los datos estén disponibles.

### 5. Filtrado de Monedas
Aunque la API proporciona una gran cantidad de pares de monedas, el proyecto se centra en algunos pares específicos, tales como:
- **USD** (Dólar)
- **ARS** (Peso Argentino)
- **BRL** (Real Brasileño)
- **COP** (Peso Colombiano)

Estos pares fueron filtrados y ofrecidos como opciones para el usuario en la interfaz de consola. Si deseas ampliar la lista de monedas disponibles, el sistema está preparado para consultar más monedas fácilmente.

### 6. Interfaz de Usuario y Presentación de Resultados
Finalmente, se desarrolló una interfaz de consola interactiva que permite al usuario:
- Elegir entre una lista predefinida de conversiones entre monedas como USD, ARS, BRL, COP.
- Ingresar un valor a convertir.
- Ver el resultado de la conversión de forma clara y sencilla.

Si el usuario desea realizar conversiones con otras monedas no predefinidas, puede elegir la opción de "Convertir otra moneda", donde podrá ingresar los códigos de las monedas de origen y destino.

### 7. Validación y Manejo de Errores
Se implementaron validaciones para asegurar que los valores ingresados por el usuario sean válidos, tanto en cuanto a las opciones del menú como en cuanto a las cantidades. Además, se maneja de manera apropiada cualquier error que pueda surgir durante la consulta de la API, garantizando que el usuario reciba mensajes claros y comprensibles en caso de fallos.

## 📦 Estructura de Archivos
- src/
  - Principal.java
  - ConsultarMoneda.java
  - ConvertirModena.java
  - Moneda.java
- config.properties

## 📑 **Ejemplo de Uso**

![image](https://drive.google.com/uc?export=view&id=1JMpz4roz_gy-8BCgwLRYlou2lYUiDgXw)
![image](https://drive.google.com/uc?export=view&id=17kRMbKruBNgi8etPY2tOr8k-651DbxzM)

## 💡 **Conclusión**
Este proyecto es una excelente forma de aprender sobre el consumo de **APIs** en **Java**, el manejo de datos **JSON** y la creación de interfaces interactivas en consola. Además, ofrece una solución útil para realizar conversiones de divisas de manera sencilla y eficiente. También es fácilmente ampliable para soportar más monedas, brindando a los usuarios aún más opciones para realizar sus conversiones.
