package es.ies.puerto;

import java.util.concurrent.Semaphore;

public class Cueva {
    private final Semaphore semaforo;
    private final int capacidad;

    public Cueva(int capacidad) {
        this.capacidad = capacidad;
        this.semaforo = new Semaphore(capacidad);
    }

    public void entrar() throws InterruptedException {
        semaforo.acquire();
    }

    public void salir() {
        semaforo.release();
    }

    public boolean estaLlena() {
        return semaforo.availablePermits() == 0;
    }
}

