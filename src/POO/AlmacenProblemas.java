package POO;

import java.io.*;
import java.util.Iterator;
import java.util.HashSet;

public class AlmacenProblemas implements Serializable {
    private HashSet<Problema> listaProblemas;

    public AlmacenProblemas(){
        this.listaProblemas = new HashSet<>();
    }

    public boolean existeProblema (Problema p){
        boolean found = false;
        Iterator<Problema> it = getListaProblemas().iterator();
        Problema aux;
        while ((!found) && it.hasNext()) {
            aux = it.next();
            found = aux.equals(p);
        }
        return found;
    }

    public HashSet<Problema> getListaProblemas() {
        return listaProblemas;
    }

    public boolean addProblema(Problema p) {
        if (!existeProblema(p))
            return this.getListaProblemas().add(p);
        else
            return false;
    }

    public boolean borrarProblema(Problema p) {
        if (!existeProblema(p))
            return getListaProblemas().remove(p);
        else
            return false;
    }

    // Meth. escribir en problema en txt (toString)
    //

    public boolean subirProblemaEnTXT(File fichero, Problema problem) throws IOException {
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(fichero)));
        salida.println(problem.toString());
        salida.close();
        return true;
    }

    public boolean validarProblema(Problema problem) {
        if (!existeProblema(problem) && EsValido(problem)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean EsValido(Problema problem) {
        return true;
    } //falta implementar

}
