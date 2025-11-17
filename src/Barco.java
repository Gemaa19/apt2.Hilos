import java.util.ArrayList;
import java.util.List;

public class Barco {

    private final List<Pasajero> pasajeros = new ArrayList<>();

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros.addAll(pasajeros);
    }

    public boolean hayPasajeros(){
        return !pasajeros.isEmpty();
    }

    public Pasajero obtenerPasajPriori(){
        if(pasajeros.isEmpty()){
            return null;
        }else {
            Pasajero pasajPrio = pasajeros.get(0);
            for (Pasajero p : pasajeros) {
                if(pasajPrio.getPrioridad()==1){
                    break;
                }else{
                    if (pasajPrio.getPrioridad()>p.getPrioridad()){
                        pasajPrio=p;
                    }
                }
            }
            return pasajPrio;
        }
    }
}
