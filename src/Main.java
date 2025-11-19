import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creamos el array de pasajeros
        List<Pasajero> pasajeros = new ArrayList<>();
        List<Pasajero> personasRecogidas = new ArrayList<>();

        Barco laAlianza = new Barco(pasajeros);

        //Creamos las 5 balsas
        Balsa balAcasta = new Balsa(1, 0.5, personasRecogidas);
        Balsa balBanff = new Balsa(2, 1,personasRecogidas);
        Balsa balCadiz = new Balsa(3, 2, personasRecogidas);
        Balsa balDeimos = new Balsa(4, 4, personasRecogidas);
        Balsa balExpedición	= new Balsa(5, 8, personasRecogidas);

        //Hacemos un bucle para crear todos los pasajeros y los añadimos al arrayList

        for (int id=1;id<=352;id++){
            int prioridad = (int)(Math.random()*(5-1)+1);
            if(prioridad == 5){
                prioridad = 1;
            }
            Pasajero pasajero = new Pasajero(id, prioridad);
            pasajeros.add(pasajero);
            System.out.println(pasajero.toString());
        }

        //añadir pasajeros a la balsa
        Rescate rescate = new Rescate(laAlianza, balAcasta, pasajeros, balAcasta.getCapacidad());
        rescate.run();
        /*personasRecogidas.add();*/


    }
}