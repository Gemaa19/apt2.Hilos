import java.util.List;

public class Rescate implements Runnable {
    private boolean hayGente;
    private Barco barco;
    private Balsa balsa;
    //private int capacidad;

    public Rescate(Barco barco, Balsa balsa, String nombreBalsa){
        this.barco = barco;
        this.balsa = balsa;
    }

    @Override
    public void run() {
        while(hayGente){
            for (int i = 0; i < balsa.getCapacidad(); i++) {
                Pasajero p = barco.obtenerPasajPriori();
                System.out.println("Balsa coge gente");
                balsa.recogerPasajero(p);
            }
            System.out.println(balsa);
            try{
                Thread.sleep((long)balsa.getTiempo()*1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(!barco.hayPasajeros()){
                hayGente = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Rescate{" +
                "hayGente=" + hayGente +
                ", barco=" + barco +
                ", balsa=" + balsa +
                '}';
    }
}
