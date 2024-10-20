package es.ies.puerto;

import java.util.Random;

class Monstruo extends Thread {
    private String nombre;
    private boolean atrapado = false;
    private String ubicacion;
    private Mapa mapa;
    private Random random = new Random();
    private boolean turnoPerdido = false;
    private boolean velocidadAumentada = false;

    public Monstruo(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
    }
    public void setTurnoPerdido(boolean perdido) {
        this.turnoPerdido = perdido;
    }
    public void setvelocidadAumentada(boolean aumentada) {
        this.velocidadAumentada = aumentada;
    }


    public String getNombre() {
        return nombre;
    }

    public boolean estaAtrapado() {
        return atrapado;
    }

    public void atrapar() {
        atrapado = true;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
public void run() {
    try {
        while (!Thread.currentThread().isInterrupted()) {
            if(turnoPerdido){
                System.out.println(nombre + " pierde su turno.");
                turnoPerdido = false;
                
            }else{
            // Verificar si hay cazadores cercanos
            boolean cazadorCercano = mapa.hayCazadorCercano(this);

            String nuevaUbicacion;

            if (cazadorCercano) {
                // Mover a una nueva ubicación aleatoria, asegurando huir del cazador
                nuevaUbicacion = mapa.generarUbicacionLejosDeCazador(this);
            } else {
                // Simple movimiento aleatorio
                nuevaUbicacion = mapa.generarUbicacion();
            }

            mapa.moverMonstruo(this, nuevaUbicacion);
            System.out.println(nombre + " se movió a " + nuevaUbicacion);
            
        }

        if(velocidadAumentada) { 
            System.out.println(nombre + " se mueve más rápido el siguiente turno.");
            // Esperar un tiempo antes de moverse de nuev   o (simula el movimiento del monstruo)
            Thread.sleep(1500 + random.nextInt(1500));
        }else{
            Thread.sleep(3000 + random.nextInt(3000));
        }
    }
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();  // Termina el hilo cuando es interrumpido
    }

    }
}
