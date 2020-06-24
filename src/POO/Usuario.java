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
    public Usuario (String nombre, String password, int problemas_intentados, int problemas_resueltos, int errores){
        this.login=nombre;
        this.pwd=password;
        this.problemas_intentados = problemas_intentados;
        this.problemas_resueltos = problemas_resueltos;
        this.errores = errores;
    }

    public int newError() {
        return this.errores++;
    }
    public void problemaIntentado(Problema p){
        if(!p.getIntentado_por().contains(this)){
            p.getIntentado_por().add(this);
            this.problemas_intentados++;
            updatePorcentajeExitos();
            p.updatePorcentajeExitos();
        }
    }
    public void problemaFallido(Problema p){
        if(!p.getResuelto_por().contains(this))
            this.errores++;
    }
    public void problemaResuelto(Problema p){
        if(!p.getResuelto_por().contains(this)){
            p.getResuelto_por().add(this);
            this.problemas_resueltos++;
            updatePorcentajeExitos();
            p.updatePorcentajeExitos();
        }
    }
    public void updatePorcentajeExitos(){
        porcentaje_exito = problemas_resueltos / problemas_intentados * 100;
    }
    
    @Override
    public String toString(){
        return login+"  "+problemas_intentados+" \t"+problemas_resueltos+" \t"+errores+"\t"+porcentaje_exito;
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
        return this.porcentaje_exito;
    }
} // END USUARIO
