package es.ies.puerto;

class Monstruo {
    private String nombre;
    private boolean atrapado = false;
    private String ubicacion;

    public Monstruo(String nombre) {
        this.nombre = nombre;
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
}