package es.ies.puerto;

import java.util.Random;

class Cazador extends Thread {
    private String nombre;
    private Mapa mapa;
    private int capturas = 0;
    private Random random = new Random();

    public Cazador(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
    }

    public int getCapturas() {
        return capturas;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Mover cazador a una nueva ubicación aleatoria
                String nuevaUbicacion = mapa.generarUbicacion();
                mapa.moverCazador(this, nuevaUbicacion);
                
                // Intentar capturar monstruo si están en la misma ubicación
                Monstruo monstruo = mapa.getMonstruoEnUbicacion(nuevaUbicacion);
                if (monstruo != null && !monstruo.estaAtrapado()) {
                    if (random.nextDouble() < 0.7) {  // 70% de probabilidad de éxito
                        monstruo.atrapar();
                        capturas++;
                        System.out.println(nombre + " atrapó a " + monstruo.getNombre() + " en " + nuevaUbicacion);
                    } else {
                        System.out.println(nombre + " falló al intentar atrapar a " + monstruo.getNombre());
                    }
                }

                // Mostrar el estado actual del mapa
                mapa.mostrarMapa();

                // Esperar un tiempo antes de moverse de nuevo (simula la caza)
                Thread.sleep(1000 + random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Termina el hilo cuando es interrumpido
        }
    }
}