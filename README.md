# Proyecto Cazador vs Monstruo

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
.  .  .  .  .
.  .  .  .  .
C  .  .  M  .
C  .  .  M  .
M  .  .  .  .

### Mapa Ejemplo 1

<div class="snippet-clipboard-content notranslate position-relative overflow-auto" data-snippet-clipboard-copy-content=".  .  .  .  .
.  .  .  .  .
C  .  .  M  .
C  .  .  M  .
M  .  .  .  ."><pre lang="plaintext" class="notranslate"><code>.  .  .  .  .
.  .  .  .  .
C  .  .  M  .
C  .  .  M  .
M  .  .  .  .
</code></pre></div>



### Mapa Ejemplo 2
<div class="snippet-clipboard-content notranslate position-relative overflow-auto" data-snippet-clipboard-copy-content=".  .  .  .  .
.  C  .  M  .
M  .  .  .  .
.  .  B  C  .
.  .  .  .  ."><pre lang="plaintext" class="notranslate"><code>.  .  .  .  .
.  C  .  M  .
M  .  .  .  .
.  .  B  C  .
.  .  .  .  .
</code></pre></div>


### Mapa Ejemplo 3



<div class="snippet-clipboard-content notranslate position-relative overflow-auto" data-snippet-clipboard-copy-content=".  T  .  C  .
M  .  M  .  .
.  .  M  .  .
.  .  .  .  .
.  .  .  .  C"><pre lang="plaintext" class="notranslate"><code>.  T  .  C  .
M  .  M  .  .
.  .  M  .  .
.  .  .  .  .
.  .  .  .  C
</code></pre></div>