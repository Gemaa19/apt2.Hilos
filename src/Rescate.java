import java.util.List;
import java.util.concurrent.Semaphore;

public class Rescate implements Runnable {
    private boolean hayGente = true;
    private Barco barco;
    private Balsa balsa;
    private Semaphore semaphore;

    public Rescate(Barco barco, Semaphore semaphore, Balsa balsa) {
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
        while (hayGente) {
            System.out.println("La balsa " + balsa.getNombre() + " ve gente que rescatar: " + barco.hayPasajeros());
            try {
                this.getSemaphore().acquire();
                System.out.println(balsa.getNombre() + " ha conseguido su turno...");
                subirBalsa();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.getSemaphore().release();
            try {
                Thread.sleep((int) (balsa.getTiempo() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bajarBalsa();
            System.out.println(balsa.getNombre() + " ha conseguido su turno...");
            if (!barco.hayPasajeros()) {
                hayGente = false;
                System.out.println("La balsa " + balsa.getNombre() + " ve que no queda gente en el barco");
            }
        }
    }

    //suben a la balsa
    public synchronized void subirBalsa() {
        System.out.println("La balsa " + balsa.getNombre() + " comienza a recoger pasajeros");
        for (int i = 0; i < balsa.getCapacidad(); i++) {
            Pasajero p = obtenerPasajPriori();
            if (p == null) {
                break;
            }
            //Cuando rescata al pasajero hay que sacarlo del Barco
            barco.getPasajerosBarco().remove(p);
            balsa.recogerPasajero(p);
            System.out.println("Balsa " + balsa.getNombre() + ": Pasajero " + (i + 1) + " con id: " + p.getId());
        }
        System.out.println("La balsa " + balsa.getNombre() + " ha recogido " + balsa.getCapacidad() + " pasajeros.");
    }

    public synchronized Pasajero obtenerPasajPriori() {
        Pasajero pasajPrio = null;
        if (!(barco.getPasajerosBarco().isEmpty())) {
            pasajPrio = barco.getPasajerosBarco().get(0);
            for (Pasajero p : barco.getPasajerosBarco()) {
                if (pasajPrio.getPrioridad() == 1) {
                    break;
                } else {
                    if (pasajPrio.getPrioridad() > p.getPrioridad()) {
                        pasajPrio = p;
                    }
                }

        }


        }
        return pasajPrio;
    }

    //bajar la gente de la balsa para que pueda volver a coger gente
    public synchronized void bajarBalsa() {
        balsa.quitarPersonas(obtenerPasajPriori());
        System.out.println("La balsa " + balsa.getNombre() + " deja sus pasajeros en tierra");
    }
}
