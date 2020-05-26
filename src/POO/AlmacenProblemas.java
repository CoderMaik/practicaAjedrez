package src.POO;

import java.io.*;
import java.util.Iterator;
import java.util.HashSet;

public class AlmacenProblemas implements Serializable {
    private HashSet<Problema> listaProblemas;

    public AlmacenProblemas(){
        this.listaProblemas = new HashSet<>();
    }
    public boolean existeProblema (Problema p){
        boolean encontrado = false;
        Iterator <Problema> it = getListaProblemas().iterator();
        Problema aux;
        while ((!encontrado) && it.hasNext()){
            aux = it.next();
            encontrado = aux.equals(p);
        }
        return encontrado;
    }

    public HashSet<Problema> getListaProblemas(){
        return listaProblemas;
    }
    public boolean anadirProblema (Problema p){
        if (existeProblema(p))
            return false;
        else
            return this.getListaProblemas().add(p);
    }
    public boolean borrarProblema (Problema p){
        if (!existeProblema(p))
            return false;
        else
            return getListaProblemas().remove(p);
    }

    // Meth. escribir en problema en txt
    //

    public boolean subirProblemaEnTXT(File fichero, Problema problem) throws IOException { // Pasamos el problema que queremos anhadir
        FileWriter fileOut = new FileWriter(fichero);
        BufferedWriter buffer = new BufferedWriter(fileOut);
        PrintWriter salida = new PrintWriter(buffer);
        salida.println(anadirProblema(problem));
        salida.close();
        return true;
    }
    public boolean validarProblema (Problema problem){
        if (!existeProblema(problem) && EsVaalido(problem)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean EsVaalido(Problema problem) {

    }

}
