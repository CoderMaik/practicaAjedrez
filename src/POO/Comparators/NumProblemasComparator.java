package POO.Comparators;

import POO.Usuario;
import java.util.Comparator;

public class NumProblemasComparator implements Comparator<Usuario> {
    @Override
    public int compare(Usuario u1, Usuario u2){
        return u2.getProblemas_resueltos()-u1.getProblemas_resueltos();
    }
}
