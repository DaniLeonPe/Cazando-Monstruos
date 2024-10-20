package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Juego {
    public static void main(String[] args) throws InterruptedException {
        int size = 5;  // Tamaño del mapa
        int tiempoDeJuego = 30000;  // Duración del juego en milisegundos
        int numCazadores = 2; // Número de cazadores a generar
        int numMonstruos = 3; // Número de monstruos a generar

        Mapa mapa = new Mapa(size);
        Evento evento = new Evento(mapa);

        // Crear y añadir monstruos al mapa
        List<Monstruo> monstruos = new ArrayList<>();
        for (int i = 1; i <= numMonstruos; i++) {
            Monstruo monstruo = new Monstruo("Monstruo" + i, mapa);
            mapa.agregarMonstruo(monstruo, mapa.generarUbicacion());
            monstruos.add(monstruo);
            monstruo.start();
        }

        // Crear cazadores y lanzarlos como hilos
        List<Cazador> cazadores = new ArrayList<>();
        for (int i = 1; i <= numCazadores; i++) {
            Cazador cazador = new Cazador("Cazador" + i, mapa);
            cazadores.add(cazador);
            cazador.start();
        }

        // Programar eventos cada 5 segundos
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> evento.generarEvento(), 0, 5, TimeUnit.SECONDS);

        // Esperar a que termine el tiempo de juego
        Thread.sleep(tiempoDeJuego);

        // Interrumpir los hilos de los cazadores y monstruos
        for (Cazador cazador : cazadores) {
            cazador.interrupt();
        }
        for (Monstruo monstruo : monstruos) {
            monstruo.interrupt();
        }

        // Detener el scheduler
        scheduler.shutdown();

        // Esperar a que los hilos terminen
        for (Cazador cazador : cazadores) {
            cazador.join();
        }
        for (Monstruo monstruo : monstruos) {
            monstruo.join();
        }

        // Mostrar el resultado final
        System.out.println("Fin del juego.");
        for (Cazador cazador : cazadores) {
            System.out.println(cazador.getNombre() + " capturó " + cazador.getCapturas() + " monstruos.");
        }
    }
}
