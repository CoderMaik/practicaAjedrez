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

    
    public Problema problemAleatorio (){
        return listaProblemas.get((int) Math.floor( Math.random()*10+1));
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

    public void leerAlmacenProblemas (File fichero) throws IOException, ClassNotFoundException{
        FileInputStream f = new FileInputStream (fichero);
        ObjectInputStream entrada = new ObjectInputStream (f);
        Problema p = (Problema) entrada.readObject ();
        this.listaProblemas = getListaProblemas();
        entrada.close();
    }
    // SERIALIZAR ALMACENLOGIN (no es definitivo)
    /*private boolean serializarAL(String n)  throws FileNotFoundException,IOException, ClassNotFoundException{
        try{
        FileInputStream fichero = new FileInputStream(n);
        ObjectInputStream input = new ObjectInputStream(fichero);

        Object aux = null;
        while ((aux = input.readObject()) !=null)
        {
            if (aux instanceof AlmacenLogin)
                this.addProblema((Problema) aux);

        }
        entrada.close();
        }
        catch (EOFException finFile){ return true;}
        catch (FileNotFoundException noEncontrado){ return false;}
        catch (IOException e){ return false;}
        return true;
      }*/
}
