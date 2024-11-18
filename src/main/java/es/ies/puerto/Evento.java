package es.ies.puerto;

import java.util.Random;

public class Evento {
    private final Mapa mapa;
    private final Random random = new Random();

    public Evento(Mapa mapa) {
        this.mapa = mapa;
    }

    public void generarEvento() {
        String tipoEvento = random.nextBoolean() ? "trampa" : "bonificacion";
        String ubicacion = mapa.generarUbicacion();

        if (tipoEvento.equals("trampa")) {
            System.out.println("Se ha activado una trampa en " + ubicacion);
            mapa.activarTrampa(ubicacion);
        } else {
            System.out.println("Se ha activado una bonificación en " + ubicacion);
            mapa.activarBonificacion(ubicacion);
        }
    }
}
