# README.md

## Descripción del Juego

Este proyecto implementa un juego simple donde cazadores intentan atrapar monstruos en un mapa de tamaño definido. El juego se desarrolla en un entorno multihilo, permitiendo que múltiples cazadores interactúen simultáneamente con los monstruos. Cada cazador se mueve a ubicaciones aleatorias en el mapa, intentando atrapar monstruos que se encuentran en la misma ubicación.

### Estructura del Código

El código está organizado en varias clases:

1. **Cazador**: Representa a un cazador que se mueve por el mapa y trata de atrapar monstruos. Utiliza un hilo para su ejecución.
   - **Métodos Principales**:
     - `run()`: Método que se ejecuta en el hilo, donde el cazador se mueve y trata de atrapar monstruos.
     - `getCapturas()`: Devuelve la cantidad de monstruos atrapados por el cazador.

2. **Monstruo**: Representa a un monstruo en el juego.
   - **Métodos Principales**:
     - `atrapar()`: Marca al monstruo como atrapado.
     - `estaAtrapado()`: Verifica si el monstruo ha sido atrapado.

3. **Mapa**: Maneja la ubicación de cazadores y monstruos en el juego.
   - **Métodos Principales**:
     - `generarUbicacion()`: Genera ubicaciones aleatorias en el mapa.
     - `moverCazador()`: Mueve a un cazador a una nueva ubicación.
     - `agregarMonstruo()`: Añade un monstruo a una ubicación específica.
     - `getMonstruoEnUbicacion()`: Devuelve el monstruo en una ubicación determinada.
     - `mostrarMapa()`: Imprime el estado actual del mapa en la consola.

4. **Juego**: Clase principal que inicia el juego.
   - **Métodos Principales**:
     - `main()`: Configura el juego, crea cazadores y monstruos, y controla el flujo del juego.

### Ejecución del Juego

Se inicia la clase `Juego`. La duración del juego está establecida en 30 segundos, y puedes ajustar el número de cazadores y monstruos en el código.

### Salida de Ejemplo

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
