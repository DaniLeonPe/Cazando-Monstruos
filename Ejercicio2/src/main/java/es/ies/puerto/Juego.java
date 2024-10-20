package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    public static void main(String[] args) throws InterruptedException {
        int size = 5;  // Tamaño del mapa
        int tiempoDeJuego = 30000;  // Duración del juego en milisegundos
        int numCazadores = 2; // Número de cazadores a generar
        int numMonstruos = 3; // Número de monstruos a generar

        Mapa mapa = new Mapa(size);

        // Crear y añadir monstruos al mapa
        for (int i = 1; i <= numMonstruos; i++) {
            Monstruo monstruo = new Monstruo("Monstruo" + i);
            mapa.agregarMonstruo(monstruo, mapa.generarUbicacion());
        }

        // Crear cazadores y lanzarlos como hilos
        List<Cazador> cazadores = new ArrayList<>();
        for (int i = 1; i <= numCazadores; i++) {
            Cazador cazador = new Cazador("Cazador" + i, mapa);
            cazadores.add(cazador);
            cazador.start();
        }

        // Esperar a que termine el tiempo de juego
        Thread.sleep(tiempoDeJuego);

        // Interrumpir los hilos de los cazadores
        for (Cazador cazador : cazadores) {
            cazador.interrupt();
        }

        // Esperar a que los hilos terminen
        for (Cazador cazador : cazadores) {
            cazador.join();
        }

        // Mostrar el resultado final
        System.out.println("Fin del juego.");
        for (Cazador cazador : cazadores) {
            System.out.println(cazador.getNombre() + " atrapó " + cazador.getCapturas() + " monstruos.");
        }
    }
}