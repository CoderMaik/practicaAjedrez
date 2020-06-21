package POO;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

public class AlmacenProblemas implements Serializable {
    private ArrayList<Problema> listaProblemas;
    private Problema [] listadoProblemas; // Para pasar a Array

    public AlmacenProblemas(){
        this.listaProblemas = new ArrayList<>();
    }

    public boolean existeProblema (Problema p){
        boolean found = false;
        Iterator<Problema> it = listaProblemas.iterator();
        Problema aux;
        while ((!found) && it.hasNext()) {
            aux = it.next();
            found = aux.equals(p);
        }
        return found;
    }

    public ArrayList<Problema> getListaProblemas() {
        return listaProblemas;
    }

    public boolean addProblema(Problema p) {
        if (!existeProblema(p))
            return this.listaProblemas.add(p);
        else
            return false;
    }

    public boolean borrarProblema(Problema p) {
        if (!existeProblema(p))
            return listaProblemas.remove(p);
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
        throw new RuntimeException("not implemented yet");
    }

    
    public Problema problemAleatorio (Usuario u) throws Exception {
        if(u.getListaResueltos().size()==this.listaProblemas.size())
            throw new Exception("Ha resuelto todos los problemas");
        while(true){
            Problema p = listaProblemas.get((int) Math.floor( Math.random()*10+1));
            if(!u.getListaResueltos().contains(p))
                return p;
        }
    }
        /*Lo dejo comentado para saber las soluciones a los problemas pero no sirve
            case 1:
                jugada_ganadora = "Td8++";
            case 2:
                jugada_ganadora = "Cg6++";
            case 3:
                jugada_ganadora = "fxg8=C++";
            case 4:
                jugada_ganadora = "f8=D++";
            case 5:
                jugada_ganadora = "dxe8=C++";
            case 6:
                jugada_ganadora= "Dc6++";
            case 7:
                jugada_ganadora = "Cd7++ ";
            case 8:
                jugada_ganadora = "Cxe6++";
            case 9:
                jugada_ganadora = "h7++";
            case 10:
                jugada_ganadora = "TxC7++";*/
    
    // BINARIO
    public void escribeAlmacenProblemas(String n) throws IOException{
        FileOutputStream fileOut=new FileOutputStream(n);
        ObjectOutputStream salida=new ObjectOutputStream(fileOut);
        for (Problema p: getListaProblemas())
            salida.writeObject(p);
        salida.close();
    }

    private boolean leerAlmacenProblemas (String nameFile) throws FileNotFoundException,IOException, ClassNotFoundException {
        try {
            FileInputStream fichero = new FileInputStream(nameFile);
            ObjectInputStream input = new ObjectInputStream(fichero);

            Object aux = null;
            while ((aux = input.readObject()) != null) {
                if (aux instanceof Problema)
                    this.addProblema((Problema) aux);
            }
            input.close();
        } catch (EOFException finFile) {
            return true;
        } catch (IOException noEncontrado) {
            return false;
        }
        return true;
    }
}
