import java.util.ArrayList;
import java.util.List;

public class Balsa {

    private int capacidad;
    private double tiempo;
    private List<Pasajero> personasRecogidas;

    public Balsa() {
    }

    public Balsa(int capacidad, double tiempo, List<Pasajero> personasRecogidas) {
        this.capacidad = capacidad;
        this.tiempo = tiempo;
        this.personasRecogidas.addAll(personasRecogidas);
    }

    public int getCapacidad() {
        return capacidad;
    }

}
