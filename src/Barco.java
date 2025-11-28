import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Barco {

    private final List<Pasajero> pasajerosBarco = new ArrayList<>();

    public Barco(List<Pasajero> pasajerosBarco) {
        this.pasajerosBarco.addAll(pasajerosBarco);
    }

    public boolean hayPasajeros(){
        return !pasajerosBarco.isEmpty();
    }

    public List<Pasajero> getPasajerosBarco() {
        return pasajerosBarco;
    }
}
