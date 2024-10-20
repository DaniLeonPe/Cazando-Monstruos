# README.md

## Descripción General

Este proyecto simula un juego interactivo en el que cazadores intentan capturar monstruos en un mapa. Los cazadores se mueven aleatoriamente y pueden caer en trampas o recoger bonificaciones, mientras que los monstruos intentan evadir a los cazadores. El juego se desarrolla durante un tiempo determinado, y al final se muestran los resultados de las capturas, así como las estadísticas del juego. Además, los monstruos tienen la opción de esconderse en cuevas durante el juego.

## Estructura del Proyecto

El proyecto se organiza en varios archivos Java, cada uno con una función específica:

1. **Cazador.java**: Representa a los cazadores que intentan capturar a los monstruos.
2. **Monstruo.java**: Representa a los monstruos que intentan escapar de los cazadores.
3. **Mapa.java**: Maneja la creación y el estado del mapa, así como las interacciones entre cazadores, monstruos, trampas y bonificaciones. Incluye la funcionalidad para generar cuevas.
4. **Evento.java**: Genera eventos aleatorios como trampas o bonificaciones en el mapa.
5. **Cueva.java**: Representa las cuevas en el mapa donde los monstruos pueden esconderse. Controla la entrada y salida de los monstruos en las cuevas y su capacidad.
6. **Juego.java**: Clase principal que inicia el juego, crea los cazadores y monstruos, y controla el flujo del juego.

## Funcionalidad

- **Cazadores**:
  - Se mueven aleatoriamente en el mapa.
  - Pueden perder turnos si caen en trampas.
  - Pueden capturar monstruos si están en la misma ubicación y tienen éxito en un intento de captura.

- **Monstruos**:
  - Se mueven aleatoriamente, pero intentan alejarse de los cazadores.
  - Pueden caer en trampas o recibir bonificaciones que afectan su comportamiento.
  - Pueden esconderse en cuevas durante un tiempo limitado para evadir a los cazadores.

- **Cuevas**:
  - Se generan aleatoriamente en el mapa como ubicaciones donde los monstruos pueden esconderse.
  - Los monstruos que entran en una cueva pueden permanecer ocultos durante un máximo de 4 segundos, con un límite de 2 monstruos por cueva.
  - Los cazadores no pueden entrar en las cuevas.

- **Eventos**:
  - Se generan trampas y bonificaciones en ubicaciones aleatorias del mapa cada 5 segundos.
  - Las trampas hacen que un cazador o monstruo pierda su turno.
  - Las bonificaciones otorgan ventajas temporales a cazadores o monstruos.

## Ejecución del Programa

Para ejecutar el programa, sigue estos pasos:

1. Compila todas las clases en el mismo paquete.
2. Ejecuta la clase `Juego`.

## Salida Esperada

A continuación se presentan tres ejemplos de salidas que se pueden generar durante la ejecución del juego, dependiendo de los movimientos aleatorios y los eventos generados:


- **C**: Cazador
- **M**: Monstruo
- **T**: Trampa
- **B**: Bonificacion
- **U**: Cueva
- **.**: Espacio vacío


### Ejemplo de Salida 1


```plaintext
.  .  .  U  .
.  .  .  M  .
.  .  T  C  B
.  .  B  M  .
C  .  .  .  .


Monstruo1 se movió a 2,0
Monstruo3 ha caído en una trampa y no puede moverse el siguiente turno.
Monstruo3 se movió a 0,1
Cazador1 atrapó a Monstruo1 en 1,2
Cazador2 falló al intentar atrapar a Monstruo2
Cazador1 atrapó a Monstruo3 en 2,3
Cazador2 atrapó a Monstruo1 en 3,1
Fin del juego.
Cazador1 atrapó 2 monstruos.
Cazador2 atrapó 1 monstruos.
```



### Ejemplo de Salida 2

```plaintext
.  .  .  U  M
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


### Ejemplo de Salida 3

```plaintext
.  .  U  M  .
M  C  .  T  .
.  .  .  .  .
.  C  .  .  .
.  .  M  .  .

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
