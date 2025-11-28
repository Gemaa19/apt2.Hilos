import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creamos el array de pasajeros
        List<Pasajero> pasajeros = new ArrayList<>();

        Semaphore semaphore = new Semaphore(1);

        //Hacemos un bucle para crear todos los pasajeros y los añadimos al arrayList
        for (int id=1;id<=352;id++){
            int prioridad = (int)(Math.random()*(5-1)+1);
            if(prioridad == 5){
                prioridad = 1;
            }
            Pasajero pasajero = new Pasajero(id, prioridad);
            pasajeros.add(pasajero);
        }
        //Creo el barco
        Barco barco = new Barco(pasajeros);
        //Creo los hilos del rescate, con cada balsa
        Thread t1 = new Thread(new Rescate(barco, semaphore, new Balsa(1, 0.5, "Acasta")));
        Thread t2 = new Thread(new Rescate(barco, semaphore, new Balsa(2, 1,"Banff")));
        Thread t3 = new Thread(new Rescate(barco, semaphore, new Balsa(3, 2, "Cadiz")));
        Thread t4 = new Thread(new Rescate(barco, semaphore, new Balsa(4, 4, "Deimos")));
        Thread t5 = new Thread(new Rescate(barco, semaphore, new Balsa(5, 8, "Expedición")));

        //iniciamos los hilos
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}