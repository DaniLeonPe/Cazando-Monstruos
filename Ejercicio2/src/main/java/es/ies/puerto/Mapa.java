package es.ies.puerto;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

class Mapa {
    private final int size;
    private ConcurrentHashMap<String, String> ubicaciones = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Monstruo> monstruos = new ConcurrentHashMap<>();
    private Random random = new Random();

    public Mapa(int size) {
        this.size = size;
    }

    // Generar una ubicación aleatoria en el mapa
    public String generarUbicacion() {
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        return x + "," + y;
    }

    // Mover cazador a una nueva ubicación, usando synchronized para garantizar acceso seguro
    public synchronized void moverCazador(Cazador cazador, String nuevaUbicacion) {
        ubicaciones.put(cazador.getName(), nuevaUbicacion);
    }

    // Añadir un monstruo en una ubicación específica, usando synchronized
    public synchronized void agregarMonstruo(Monstruo monstruo, String ubicacion) {
        monstruo.setUbicacion(ubicacion);
        monstruos.put(ubicacion, monstruo);
    }

    public synchronized void moverMonstruo(Monstruo monstruo, String nuevaUbicacion) {
            ubicaciones.put(monstruo.getNombre(), nuevaUbicacion);
    }

    // Obtener el monstruo en una ubicación específica
    public synchronized Monstruo getMonstruoEnUbicacion(String ubicacion) {
        return monstruos.get(ubicacion);
    }

    // Eliminar un monstruo del mapa (cuando es atrapado o desaparece)
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
                mapaVisual[x][y] = "M";
            }
        }

        // Colocar cazadores en el mapa
        for (Map.Entry<String, String> entry : ubicaciones.entrySet()) {
            
            String[] coords = entry.getValue().split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            mapaVisual[x][y] = "C";
        }

        // Imprimir el mapa
        for (String[] fila : mapaVisual) {
            System.out.println(String.join("  ", fila));
        }
        System.out.println();  
    }
}
