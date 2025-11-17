import java.util.List;

public class Rescate implements Runnable {
    private boolean hayGente;
    private Barco barco;

    public Rescate(Barco barco, List<Pasajero> pasajeros){
        this.barco = barco;
        hayGente = barco.hayPasajeros();
    }

    @Override
    public void run() {
        while(hayGente){
            barco.obtenerPasajPriori();
            System.out.println("Balsa coge gente");
        }
    }
}
