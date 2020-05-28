package POO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Clasificacion {

    private ArrayList<Usuario> ListaClasificacion;

    public Clasificacion() {
        //Método que pase el HashSet a ArrayList y lo meta en ListaClasificacion
    }

    public ArrayList<Usuario> getListaClasificacion() {
        return ListaClasificacion;
    }

    public ArrayList<Usuario> ordenarPorcentaje() {
        Collections.sort(ListaClasificacion, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return new Integer(u1.getPorcentaje_exito()).compareTo(new Integer(u2.getPorcentaje_exito()));
            }
        });
        return ListaClasificacion;
    }

    public void listaOrdenadaPorcentajes () {
        ArrayList <Usuario> estadistica = ordenarPorcentaje();
        for (Usuario u : estadistica) {
                System.out.println("Usuario: " + u.getNombre());
                System.out.println("Problemas intentados: " + u.getProblemas_intentados());
                System.out.println("Problemas resueltos: " + u.getProblemas_resueltos());
                System.out.println("Errores totales: " + u.getErrores());
                System.out.println("Porcentaje de éxitos: " + u.getPorcentaje_exito());
                System.out.println();
        }
    }

    public ArrayList<Usuario> ordenarResueltos(){
        Collections.sort(ListaClasificacion, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return new Integer(u1.getProblemas_resueltos()).compareTo(new Integer(u2.getProblemas_resueltos()));
            }
        });
        return ListaClasificacion;
    }

    public void listaReordenada () {
        ArrayList <Usuario> estadistica1 = ordenarPorcentaje();
        for (Usuario u : estadistica1) {
            System.out.println("Usuario: " + u.getNombre());
            System.out.println("Problemas intentados: " + u.getProblemas_intentados());
            System.out.println("Problemas resueltos: " + u.getProblemas_resueltos());
            System.out.println("Errores totales: " + u.getErrores());
            System.out.println("Porcentaje de éxitos: " + u.getPorcentaje_exito());
            System.out.println();
        }
    }
}


