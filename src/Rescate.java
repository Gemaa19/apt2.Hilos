import java.util.List;

public class Rescate implements Runnable {
    private boolean hayGente = true;
    private Barco barco;
    private Balsa balsa;

    public Rescate(Barco barco, Balsa balsa){
        this.barco = barco;
        this.balsa = balsa;
    }

    @Override
    public void run() {
        while(hayGente){
            System.out.println("La balsa " + balsa.getNombre() + " ve que gente que rescatar: " + barco.hayPasajeros());
            subirBalsa();
            System.out.println("Pasajeros rescatados en la balsa:" + balsa);
            try{
                Thread.sleep((int) (balsa.getTiempo()*1000));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            bajarBalsa();
            if(!barco.hayPasajeros()){
                hayGente = false;
                System.out.println("La balsa " + balsa.getNombre() + " ve que no queda gente en el barco");
            }
        }
    }

    //suben a la balsa
    public synchronized void subirBalsa(){
        for (int i = 0; i < balsa.getCapacidad(); i++) {
            Pasajero p = barco.obtenerPasajPriori();
            if (p == null){
                break;
            }
            balsa.recogerPasajero(p);
        }
        System.out.println("La balsa " + balsa.getNombre() + " ha recogido " + balsa.getCapacidad());
    }
    //bajar la gente de la balsa para que pueda volver a coger gente
    public void bajarBalsa(){
        balsa.quitarPersonas(barco.obtenerPasajPriori());
        System.out.println("La balsa " + balsa.getNombre() + " deja sus pasajeros en tierra");
    }
}
