import java.util.ArrayList;
import java.util.List;

public class Barco {

    private final List<Pasajero> pasajerosBarco = new ArrayList<>();

    public Barco(List<Pasajero> pasajerosBarco) {
        this.pasajerosBarco.addAll(pasajerosBarco);
    }

    public boolean hayPasajeros(){
        return !pasajerosBarco.isEmpty();
    }

    public Pasajero obtenerPasajPriori(){
        if(pasajerosBarco.isEmpty()){
            return null;
        }else {
            Pasajero pasajPrio = pasajerosBarco.get(0);
            for (Pasajero p : pasajerosBarco) {
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
