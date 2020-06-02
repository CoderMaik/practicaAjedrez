package POO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Clasificacion{
    private Usuario[] listaClasificacion;
    //Contrsuctor
    public Clasificacion (Usuario[] lista ){
        this.listaClasificacion = lista;
    }

    // HashSet to ArrayList
    private Usuario[] HashSet_ToArray(HashSet<Usuario> listaUsuarios){
       listaUsuarios.toArray(listaClasificacion);
       return listaClasificacion;
    }

    private Usuario[] ordenPorcentaje(HashSet<Usuario> listaUsuarios){
        listaUsuarios.toArray(listaClasificacion);
        int size = listaClasificacion.length;
        for(int i = 0; i < size - 1; i++){
            for (int j = i + 1; j < size; j++){
                if (listaClasificacion[i].getPorcentaje_exito() > listaClasificacion[j].getPorcentaje_exito()){
                Usuario aux = listaClasificacion[i];
                listaClasificacion[i] = listaClasificacion[j];
                listaClasificacion[j] = aux;
                }
            }
        }
        return listaClasificacion;
    }

    private Usuario[] ordenProblemasResueltos (HashSet<Usuario> listaUsuarios){
        listaUsuarios.toArray(listaClasificacion);
        int size = listaClasificacion.length;
        for(int i = 0; i < size - 1; i ++ ){
            for(int j = i +1; j < size; j++){
                if(listaClasificacion[i].getProblemas_resueltos() > listaClasificacion[j].getProblemas_resueltos()){
                    Usuario aux = listaClasificacion[i];
                    listaClasificacion[i] = listaClasificacion[j];
                    listaClasificacion[j] = aux;

                }
            }
        }
        return listaClasificacion;
    }
}//END CLASS