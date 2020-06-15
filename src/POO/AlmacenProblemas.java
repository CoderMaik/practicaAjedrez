package POO;

import java.io.*;
import java.util.Iterator;
import java.util.HashSet;

public class AlmacenProblemas implements Serializable {
    private HashSet<Problema> listaProblemas;
    private Problema [] listadoProblemas; // Para pasar a Array

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

    public void estadistiasProblemas(HashSet<Problema> problemas){
        problemas.toArray(listadoProblemas);
        int size = listadoProblemas.length;
        for (int i = 0; i < size; i++ ){
            System.out.println("LISTADO DE PROBLEMAS: ");
            System.out.println();
        }
    }

    public void AlmacenLoginTXT(File fichero) throws IOException {
        FileWriter fileOut = new FileWriter(fichero);
        BufferedWriter buffer = new BufferedWriter(fileOut);
        PrintWriter salida = new PrintWriter(buffer);

        for (Problema problema : getListaProblemas())
            salida.println(problema);
        salida.close();
    }

    public void leeAlmacenProblemasTXT(File fichero) throws IOException{
        FileReader  fileIn = new FileReader(fichero);
        BufferedReader  buffer = new BufferedReader (fileIn);
        String s="";
        String texto = "";
        while((s = buffer.readLine()) != null)
            texto += s + "\n";
        buffer.close();
    }
}
