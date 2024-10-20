# README.md

## Descripción General

Este proyecto simula un juego en el que cazadores intentan capturar monstruos en un mapa. Los cazadores se mueven aleatoriamente y pueden caer en trampas o recoger bonificaciones, mientras que los monstruos intentan evadir a los cazadores. El juego se desarrolla durante un tiempo determinado, y finalmente se muestran los resultados de las capturas.

## Estructura del Proyecto

El proyecto se organiza en varios archivos Java, cada uno de los cuales cumple una función :

1. **Cazador.java**: Representa a los cazadores que intentan capturar a los monstruos.
2. **Monstruo.java**: Representa a los monstruos que intentan escapar de los cazadores.
3. **Mapa.java**: Maneja la creación y el estado del mapa, así como las interacciones entre cazadores, monstruos, trampas y bonificaciones.
4. **Evento.java**: Genera eventos aleatorios como trampas o bonificaciones en el mapa.
5. **Juego.java**: Clase principal que inicia el juego, crea los cazadores y monstruos, y controla el flujo del juego.

## Funcionalidad

- **Cazadores**:
  - Se mueven aleatoriamente en el mapa.
  - Pueden perder turnos si caen en trampas.
  - Pueden capturar monstruos si están en la misma ubicación y tienen éxito en un intento de captura.

- **Monstruos**:
  - Se mueven aleatoriamente, pero intentan alejarse de los cazadores.
  - Pueden caer en trampas o recibir bonificaciones que afectan su comportamiento.

- **Eventos**:
  - Se generan trampas y bonificaciones en ubicaciones aleatorias del mapa cada 5 segundos.
  - Las trampas hacen que un cazador o monstruo pierda su turno.
  - Las bonificaciones otorgan ventajas temporales a cazadores o monstruos.

## Ejecución del Programa

Para ejecutar el programa, sigue estos pasos:

1. Compila todas las clases en el mismo paquete.
2. Ejecuta la clase `Juego`.

## Salida Esperada

A continuación se presentan tres ejemplos de salidas que se pueden generar durante la ejecución del juego, dependiendo de los movimientos aleatorios y los eventos generados.

### Ejemplos 

A continuación se muestra un ejemplo de cómo podría verse el mapa durante una partida. Las letras representan diferentes elementos en el mapa:

- **C**: Cazador
- **M**: Monstruo
- **T**: Trampa
- **B**: Bonificacion
- **.**: Espacio vacío


### Mapa Ejemplo 1

```plaintext
.  .  .  .  .
C  .  .  M  .
C  .  .  M  .
M  .  .  .  .

Monstruo2 pierde su turno.
Monstruo2 se movió a 4,2
Cazador1 ha caído en una trampa y no puede moverse el siguiente turno.
Cazador1 atrapó a Monstruo1 en 1,2
Cazador2 falló al intentar atrapar a Monstruo2
Cazador1 atrapó a Monstruo3 en 2,3
Cazador2 atrapó a Monstruo1 en 3,1
Fin del juego.
Cazador1 atrapó 2 monstruos.
Cazador2 atrapó 1 monstruos.
```


```plaintext
.  .  .  .  M
.  .  .  .  .
.  .  T  C  B
.  .  M  M  .
.  .  .  .  C

Cazador2 ha caído en una trampa y no puede moverse el siguiente turno.
Cazador2 falló al intentar atrapar a Monstruo3
Cazador1 atrapó a Monstruo1 en 5,1
Cazador1 falló al intentar atrapar a Monstruo2
Cazador2 atrapó a Monstruo3 en 4,3
Fin del juego.
Cazador1 capturó 1 monstruos.
Cazador2 capturó 1 monstruos.
```


### Mapa Ejemplo 3



```plaintext
.  T  .  C  .
M  .  M  .  .
.  .  M  .  .
.  .  .  .  .
.  .  .  .  C

Monstruo1 se movió a 2,0
Monstruo3 ha caído en una trampa y no puede moverse el siguiente turno.
Monstruo3 se movió a 0,1
Cazador2 atrapó a Monstruo1 en 4,1
Cazador2 falló al intentar atrapar a Monstruo1
Cazador2 atrapó a Monstruo3 en 1,2
Fin del juego.
Cazador1 capturó 0 monstruos.
Cazador2 capturó 2 monstruos.
```
