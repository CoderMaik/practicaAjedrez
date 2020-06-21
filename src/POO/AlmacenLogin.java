package POO;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;


public class AlmacenLogin {
    private static HashSet<Usuario> listaUsuarios;

    public AlmacenLogin() {
        listaUsuarios = new HashSet<>();
    }

    public static HashSet<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public boolean setListaUsuarios(HashSet<Usuario> listaUsuarios) {
        if (listaUsuarios != null) {
            this.listaUsuarios = listaUsuarios;
            return true;
        } else {
            return false;
        }
    }

    public boolean existeUsuario(Usuario u) {
        boolean found = false;
        Iterator<Usuario> it = getListaUsuarios().iterator();
        Usuario aux;
        while ((it.hasNext()) && (!found)) {
            aux = it.next();
            found = (aux.equals(u));
        }
        return found;
    }//Hace falta crear método existeUsuario(username,password)

    public Usuario getUsuario(Usuario u) {
        Iterator<Usuario> it = getListaUsuarios().iterator();
        Usuario aux;
        while (it.hasNext()) {
            aux = it.next();
            if (aux.equals(u)) {
                return u;
            }
        }
        return null;
    }

    public Usuario getUsuario(String nombre) {
        Iterator<Usuario> it = getListaUsuarios().iterator();
        Usuario aux;
        while (it.hasNext()) {
            aux = it.next();
            if (aux.getNombre().equals(nombre)) {
                return aux;
            }
        }
        return null;
    }

    public boolean existeUsuario(String name){
        return (!(getUsuario(name)==null));
    }

    public boolean anadirUsuario(Usuario u) {
        if (!existeUsuario(u)) {
            return true;
        } else {
            return false;
        }
    }

    // BINARIO

    public void escribeAlmacenLogin(String n) throws IOException{
        FileOutputStream fileOut = new FileOutputStream(n);
        ObjectOutputStream salida = new ObjectOutputStream(fileOut);
        salida.writeObject(listaUsuarios);
        salida.close();
    }

    public boolean leerAlmacenLogin (String nameFile) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fichero = new FileInputStream(nameFile);
            ObjectInputStream input = new ObjectInputStream(fichero);
            listaUsuarios = (HashSet<Usuario>)input.readObject();
            input.close();
            return true;
        } catch (ClassNotFoundException | IOException noEncontrado) { return false;
        }
    }
}
