# README.md

## Descripción General

Este proyecto simula un juego en el que cazadores intentan capturar monstruos en un mapa. El juego se desarrolla durante un tiempo determinado, y finalmente se muestran los resultados de las capturas.


## Estructura del Proyecto

El proyecto se organiza en varios archivos Java, cada uno de los cuales cumple una función :

1. **Cazador.java**: Representa a los cazadores que intentan capturar a los monstruos.
2. **Monstruo.java**: Representa a los monstruos que intentan escapar de los cazadores.
3. **Mapa.java**: Maneja la creación y el estado del mapa, así como las interacciones entre cazadores, monstruos, trampas y bonificaciones.
5. **Juego.java**: Clase principal que inicia el juego, crea los cazadores y monstruos, y controla el flujo del juego.

## Funcionalidad

- **Cazadores**:
  - Se mueven aleatoriamente en el mapa.
  - Pueden perder turnos si caen en trampas.
  - Pueden capturar monstruos si están en la misma ubicación y tienen éxito en un intento de captura.

- **Monstruos**:
  - Se mueven aleatoriamente, pero intentan alejarse de los cazadores.
  - Pueden caer en trampas o recibir bonificaciones que afectan su comportamiento.

## Ejecución del Programa

Para ejecutar el programa, sigue estos pasos:

1. Compila todas las clases en el mismo paquete.
2. Ejecuta la clase `Juego`.

### Salida Esperada

Durante la ejecución, la salida del juego se verá algo así:

```plaintext
.  .  C  .  .
.  .  M  M  .
.  .  .  M  .
.  .  .  C  .
.  .  .  .  .

Cazador1 atrapó a Monstruo1 en 1,2
Cazador2 falló al intentar atrapar a Monstruo2
Cazador1 atrapó a Monstruo3 en 2,3
Cazador2 atrapó a Monstruo1 en 3,1
Fin del juego.
Cazador1 atrapó 2 monstruos.
Cazador2 atrapó 1 monstruos.
