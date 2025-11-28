import java.util.List;
import java.util.concurrent.Semaphore;

public class Rescate implements Runnable {
    private boolean hayGente = true;
    private Barco barco;
    private Balsa balsa;
    private Semaphore semaphore;

    public Rescate(Barco barco, Semaphore semaphore, Balsa balsa){
        this.barco = barco;
        this.balsa = balsa;
        this.semaphore = semaphore;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while(hayGente){
            System.out.println("La balsa " + balsa.getNombre() + " ve que gente que rescatar: " + barco.hayPasajeros());
            subirBalsa();
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
        System.out.println("La balsa " + balsa.getNombre() + " comienza a recoger pasajeros");
        try{
            this.getSemaphore().acquire();
            for (int i = 0; i < balsa.getCapacidad(); i++) {
                Pasajero p = barco.obtenerPasajPriori();
                if (p == null){
                    break;
                }
                balsa.recogerPasajero(p);
                System.out.println("Balsa " + balsa.getNombre() + ": Pasajero " + (i+1) + " con id: "+ p.getId());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        this.getSemaphore().release();
        System.out.println("La balsa " + balsa.getNombre() + " ha recogido " + balsa.getCapacidad() + " pasajeros.");
    }

    //bajar la gente de la balsa para que pueda volver a coger gente
    public synchronized void bajarBalsa(){
        try {
            this.getSemaphore().acquire();
            balsa.quitarPersonas(barco.obtenerPasajPriori());

        }catch(InterruptedException e){
        e.printStackTrace();
    }
        this.getSemaphore().release();
        System.out.println("La balsa " + balsa.getNombre() + " deja sus pasajeros en tierra");
    }
}
