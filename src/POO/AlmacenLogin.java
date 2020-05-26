package src.POO;
import java.util.ArrayList;
import java.util.Iterator;

public class AlmacenLogin {
    private ArrayList<Usuario> listaUsuarios;

    public AlmacenLogin(){
        this.listaUsuarios=new ArrayList<>();
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public boolean existeUsuario(Usuario u){
        boolean esta = false;
        Iterator <Usuario> it = getListaUsuarios().iterator();
        Usuario aux;
        while((it.hasNext())&&(!esta)){
            aux = it.next();
            esta = (aux.equals(u));
        }
        return esta;
    }

    public Usuario getUsuario(Usuario u){
        Iterator <Usuario> it = getListaUsuarios().iterator();
        Usuario aux;
        while(it.hasNext()){
            aux = it.next();
            if (aux.equals(u)) {
                return u;
            }
        }
        return null;
    }

    public Usuario getUsuario(String nombre){
        Iterator <Usuario> it = getListaUsuarios().iterator();
        Usuario aux;
        while(it.hasNext()){
            aux = it.next();
            if (aux.getNombre().equals(nombre)) {
                return aux;
            }
        }
        return null;
    }

    public boolean anadirUsuario(Usuario u){
        if(existeUsuario(u)){
            return false;
        }else{


            //Añadir ordenando
            return true;
        }
    }
}
