package POO;

public class Usuario {
    private String login;
    private String pwd;
    private int problemas_intentados;
    private int problemas_resueltos;
    private int errores;
    private int porcentaje_exito;

    public Usuario (String nombre, String password){
        this.login=nombre;
        this.pwd=password;
        this.problemas_intentados = 0;
        this.problemas_resueltos = 0;
        this.errores = 0;
    }
    //Getters y Setters
    public String getNombre() {
        return login;
    }
    public void setNombre(String login) {
        this.login = login;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public int getProblemas_intentados() {
        return problemas_intentados;
    }
    public void setProblemas_intentados(int problemas_intentados) {
        this.problemas_intentados = problemas_intentados;
    }
    public int getProblemas_resueltos() {
        return problemas_resueltos;
    }
    public void setProblemas_resueltos(int problemas_resueltos) {
        this.problemas_resueltos = problemas_resueltos;
    }
    public int getErrores() {
        return errores;
    }
    public int getPorcentaje_exito() {
        return updatePorcentajeExitos();
    }
    public int newError() {
        return this.errores++;
    }
    private int updatePorcentajeExitos(){
        porcentaje_exito = problemas_resueltos / problemas_intentados * 100;
        return porcentaje_exito;
    }
    public void verEstadisticas(){
        /*System.out.println("Usuario: "+login);
        System.out.println("Problemas intentados: "+problemas_intentados);
        System.out.println("Problemas resueltos: "+problemas_resueltos);
        System.out.println("Errores totales: "+errores);
        System.out.println("Porcentaje de éxitos: "+updatePorcentajeExitos());*/
        Clasificacion clas = new Clasificacion();
        clas.listaOrdenadaPorcentajes();
        clas.listaReordenada();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario u = (Usuario) obj;
        return u.login.equals(this.login);
    }
}
