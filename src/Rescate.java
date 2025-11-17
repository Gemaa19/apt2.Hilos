import java.util.List;

public class Rescate implements Runnable {
    private boolean hayGente;

    public Rescate(List<Pasajero> pasajeros){
        Barco barco = new Barco(pasajeros);
        hayGente = barco.hayPasajeros();
    }

    @Override
    public void run() {
        while(hayGente){
            System.out.println("Balsa coge gente");
        }
    }
}
