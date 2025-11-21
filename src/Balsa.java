import java.util.ArrayList;
import java.util.List;

public class Balsa {

    private int capacidad;
    private double tiempo;
    private List<Pasajero> personasRecogidas  = new ArrayList<>();

    public Balsa() {
    }

    public Balsa(int capacidad, double tiempo) {
        this.capacidad = capacidad;
        this.tiempo = tiempo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getTiempo() {
        return tiempo;
    }
    public void recogerPasajero(Pasajero p){
        personasRecogidas.add(p);
    }

    @Override
    public String toString() {
        return "Balsa{" +
                "capacidad=" + capacidad +
                ", tiempo=" + tiempo +
                ", personasRecogidas=" + personasRecogidas +
                '}';
    }
}
