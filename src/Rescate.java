import java.util.List;

public class Rescate extends Thread {
    private boolean hayGente;
    private Barco barco;
    private Balsa balsa;
    private int capacidad;

    public Rescate(Barco barco, Balsa balsa, List<Pasajero> pasajeros, int capacidad){
        this.barco = barco;
        this.balsa = balsa;
        this.capacidad = capacidad;
    }

    @Override
    public void run() {
        while(hayGente){
            barco.obtenerPasajPriori();
            System.out.println("Balsa coge gente");
            balsa.getCapacidad();
        }
    }

    @Override
    public String toString() {
        return "Rescate{" +
                ", barco=" + barco +
                ", balsa=" + balsa +
                ", capacidad=" + capacidad +
                '}';
    }
}
