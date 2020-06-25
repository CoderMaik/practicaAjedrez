package POO.Comparators;

import POO.Usuario;
import java.util.Comparator;

public class PorcentajeExitosComparator implements Comparator<Usuario>{
    @Override
    public int compare(Usuario u1, Usuario u2){
        if(u1.getPorcentaje_exito()<u2.getPorcentaje_exito())return 1;
        if(u1.getPorcentaje_exito()>u2.getPorcentaje_exito())return -1;
        return 0;
    }
}
