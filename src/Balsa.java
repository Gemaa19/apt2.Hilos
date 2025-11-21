import java.util.ArrayList;
import java.util.List;

public class Balsa {

    private int capacidad;
    private double tiempo;
    private String nombre;
    private List<Pasajero> personasRecogidas  = new ArrayList<>();

    public Balsa() {
    }

    public Balsa(int capacidad, double tiempo, String nombre) {
        this.capacidad = capacidad;
        this.tiempo = tiempo;
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getTiempo() {
        return tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void recogerPasajero(Pasajero p){
        personasRecogidas.add(p);
    }

    public void quitarPersonas(){
        for (Pasajero p : personasRecogidas) {
            personasRecogidas.remove(p);
            System.out.println("Persona fuera de la barca: " + p);
        }

    }

    @Override
    public String toString() {
        return "Balsa{" +
                "capacidad=" + capacidad +
                ", tiempo=" + tiempo +
                ", nombre='" + nombre + '\'' +
                ", personasRecogidas=" + personasRecogidas +
                '}';
    }
}
