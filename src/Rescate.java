import java.util.List;

public class Rescate implements Runnable {
    private boolean hayGente;
    private Barco barco;
    private Balsa balsa;
    //private int capacidad;

    public Rescate(Barco barco, Balsa balsa){
        this.barco = barco;
        this.balsa = balsa;
    }

    @Override
    public void run() {
        while(hayGente){
           subirBalsa();
            System.out.println("Rescate{" +
                    "hayGente=" + hayGente +
                    ", barco=" + barco +
                    ", balsa=" + balsa +
                    '}');
            try{
                Thread.sleep((int) (balsa.getTiempo()*1000));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            bajarBalsa();
            if(!barco.hayPasajeros()){
                hayGente = false;
            }
        }
    }

    //suben a la balsa
    public synchronized void subirBalsa(){
        for (int i = 0; i < balsa.getCapacidad(); i++) {
            Pasajero p = barco.obtenerPasajPriori();
            System.out.println("Balsa coge gente");
            balsa.recogerPasajero(p);
        }
    }

    public void bajarBalsa(){
        balsa.quitarPersonas();
        System.out.println("Balsa baja gente");
    }
}
