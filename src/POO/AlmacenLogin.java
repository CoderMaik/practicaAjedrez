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
    }

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

    public boolean anadirUsuario(Usuario u) {
        if (!existeUsuario(u)) {
            return true;
        } else {
            return false;
        }
    }
    // TEXTO
    public void AlmacenLoginEnTXT(File fichero) throws IOException {
        FileWriter fileOut = new FileWriter(fichero);
        BufferedWriter buffer = new BufferedWriter(fileOut);
        PrintWriter salida = new PrintWriter(buffer);

        for (Usuario usuario : getListaUsuarios())
            salida.println(usuario);
        salida.close();
    }

    public void leeAlmacenLoginDeTXT(File fichero) throws IOException{
        FileReader fileIn = new FileReader(fichero);
        BufferedReader  buffer = new BufferedReader (fileIn);
        String s="";
        String texto="";
        while((s = buffer.readLine()) != null)
            texto += s + "\n";
        buffer.close();
    }

    // BINARIO
    public void escribeAlmacenLogin(String n) throws IOException{
        FileOutputStream fileOut=new FileOutputStream(n);
        ObjectOutputStream salida=new ObjectOutputStream(fileOut);
        for (Usuario u: getListaUsuarios())
            salida.writeObject(u);
        salida.close();
    }
    public void leerAlmacenLogin (File fichero) throws IOException, ClassNotFoundException{
        FileInputStream f = new FileInputStream (fichero);
        ObjectInputStream entrada = new ObjectInputStream (f);
        Usuario u = (Usuario) entrada.readObject ();
        listaUsuarios = getListaUsuarios();
        entrada.close();

    }






}
