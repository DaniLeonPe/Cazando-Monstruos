package es.ies.puerto;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Mapa {
    private final int size;
    private ConcurrentHashMap<String, String> ubicaciones = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Monstruo> monstruos = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> trampas = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> bonificaciones = new ConcurrentHashMap<>();

    public Mapa(int size) {
        this.size = size;
    }

    // Generar una ubicación aleatoria en el mapa
    public String generarUbicacion() {
        int x = new Random().nextInt(size);
        int y = new Random().nextInt(size);
        return x + "," + y;
    }

    public synchronized boolean moverCazador(Cazador cazador, String nuevaUbicacion) {
        // Verificar si la nueva ubicación ya está ocupada por otro cazador
        if (ubicaciones.containsValue(nuevaUbicacion)) {
            return false; // La ubicación está ocupada por otro cazador
        }

        // Verificar si el cazador ha caído en una trampa
        if (trampas.containsKey(nuevaUbicacion)) {
            System.out.println(cazador.getNombre() + " ha caído en una trampa y no puede moverse el siguiente turno.");
            cazador.setTurnoPerdido(true);
            return true; // El cazador se mueve a la ubicación de la trampa
        }

        // Verificar si el cazador ha caído en una bonificación
        if (bonificaciones.containsKey(nuevaUbicacion)) {
            System.out.println(cazador.getNombre() + " ha encontrado una bonificación y captura un monstruo adicional.");
            cazador.incrementarCapturas(1); // Captura adicional
            bonificaciones.remove(nuevaUbicacion); // Se quita la bonificación después de usarla
        }

        // Mover cazador a la nueva ubicación
        ubicaciones.put(cazador.getNombre(), nuevaUbicacion);
        return true; // Movimiento exitoso
    }

    public synchronized void moverMonstruo(Monstruo monstruo, String nuevaUbicacion) {
        // Remover el monstruo de su ubicación anterior
        monstruos.remove(monstruo.getUbicacion());
        monstruo.setUbicacion(nuevaUbicacion);
        monstruos.put(nuevaUbicacion, monstruo);
        
        // Verificar si el monstruo ha caído en una trampa
        if (trampas.containsKey(nuevaUbicacion)) {
            System.out.println(monstruo.getNombre() + " ha caído en una trampa y no puede moverse el siguiente turno.");
            monstruo.setTurnoPerdido(true);
        }

        // Verificar si el monstruo ha caído en una bonificación
        if (bonificaciones.containsKey(nuevaUbicacion)) {
            System.out.println(monstruo.getNombre() + " ha encontrado una bonificación y se mueve más rápido el siguiente turno.");
            monstruo.setvelocidadAumentada(true); // El monstruo se mueve más rápido el siguiente turno
            bonificaciones.remove(nuevaUbicacion); // Se quita la bonificación después de usarla
        }
    }

    public synchronized void activarTrampa(String ubicacion) {
        trampas.put(ubicacion, "activa");
        // Aquí puedes agregar lógica para afectar a los cazadores que caen en trampas
    }

    public synchronized void activarBonificacion(String ubicacion) {
        bonificaciones.put(ubicacion, "activa");
        // Aquí puedes agregar lógica para otorgar bonificaciones a cazadores que alcanzan este lugar
    }

  

    public synchronized void agregarMonstruo(Monstruo monstruo, String ubicacion) {
        monstruo.setUbicacion(ubicacion);
        monstruos.put(ubicacion, monstruo);
    }

   
    public synchronized Monstruo getMonstruoEnUbicacion(String ubicacion) {
        return monstruos.get(ubicacion);
    }

    public synchronized void eliminarMonstruo(String ubicacion) {
        monstruos.remove(ubicacion);
    }

    public void mostrarMapa() {
        String[][] mapaVisual = new String[size][size];

        // Inicializar el mapa con puntos vacíos
        for (int i = 0; i < size; i++) {
            Arrays.fill(mapaVisual[i], ".");
        }

        // Colocar monstruos en el mapa
        for (Map.Entry<String, Monstruo> entry : monstruos.entrySet()) {
            Monstruo monstruo = entry.getValue();
            if (!monstruo.estaAtrapado()) {
                String[] coords = entry.getKey().split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                mapaVisual[x][y] = "M"; // 'M' representa un monstruo
            }
        }

        // Colocar cazadores en el mapa
        for (Map.Entry<String, String> entry : ubicaciones.entrySet()) {
            String[] coords = entry.getValue().split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            mapaVisual[x][y] = "C"; // 'C' representa un cazador
        }

        // Colocar trampas en el mapa
        for (String ubicacion : trampas.keySet()) {
            String[] coords = ubicacion.split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            mapaVisual[x][y] = "T"; // 'T' representa una trampa
        }

        // Colocar bonificaciones en el mapa
        for (String ubicacion : bonificaciones.keySet()) {
            String[] coords = ubicacion.split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            mapaVisual[x][y] = "B"; // 'B' representa una bonificación
        }

        // Imprimir el mapa
        for (String[] fila : mapaVisual) {
            System.out.println(String.join("  ", fila));
        }
        System.out.println();
    }
    public synchronized boolean hayCazadorCercano(Monstruo monstruo) {
        String[] coordsMonstruo = monstruo.getUbicacion().split(",");
        int xMonstruo = Integer.parseInt(coordsMonstruo[0]);
        int yMonstruo = Integer.parseInt(coordsMonstruo[1]);

        for (String ubicacionCazador : ubicaciones.values()) {
            String[] coordsCazador = ubicacionCazador.split(",");
            int xCazador = Integer.parseInt(coordsCazador[0]);
            int yCazador = Integer.parseInt(coordsCazador[1]);

            // Verificar si el cazador está en la misma fila o columna que el monstruo
            if (xMonstruo == xCazador || yMonstruo == yCazador) {
                return true; // Hay un cazador cercano
            }
        }
        return false; // No hay cazadores cercanos
    }

    // Genera una nueva ubicación lejos de los cazadores
    public synchronized String generarUbicacionLejosDeCazador(Monstruo monstruo) {
        String nuevaUbicacion;
        boolean ubicacionValida;

        do {
            nuevaUbicacion = generarUbicacion();
            ubicacionValida = true;

            for (String ubicacionCazador : ubicaciones.values()) {
                if (nuevaUbicacion.equals(ubicacionCazador)) {
                    ubicacionValida = false; // La ubicación está ocupada por un cazador
                    break;
                }
            }
        } while (!ubicacionValida);

        return nuevaUbicacion;
    }
}

 

