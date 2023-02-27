# Calculator API
Calculadora para una prueba de Sanitas.

La aplicación está realizada mediante SpringBoot y Maven, como se solicita en el enunciado.
Es una APIRest, la cual posee un único endpoint (GET /api/v1/calculate?num1=3&num2=5&operation=add)

Además, se hace uso de una librería (tracer) que especifica en el enunciado que es necesario implementar.

# Pasos para su ejecución
1. Es necesario descargar el repositorio en local. Esto se hace mediante la instrucción git clone y seleccionando la url del repositorio actual.
2. Una vez descargado, acceder a la carpeta del proyecto y realizar un mvn clean install
3. De esta forma, se habrá generado un archivo .jar en la carpeta "target". Para ejecutarlo hay que abrir una consola en dicha ubicación y lanzar el siguiente comando: java -jar calculator-0.0.1-SNAPSHOT.jar
4. Para hacer uso de la aplicación, es necesario realizar peticiones mediante el protocolo HTTP ya que es una APIRest. Para ello podemos utilizar el software Postman.

# Postman
Para realizar operaciones, una vez arrancado, en Postman la url es la siguiente: localhost:8080/api/v1/calculate
A continuación, se añaden los QueryParams que son num1, num2 y operation. Ej: localhost:8080/api/v1/calculate?num1=3&num2=5&operation=add
Como reza el enunciado, únicamente hay dos operaciones disponibles (add y substract), las cuales son de suma y resta, respectivamente.
