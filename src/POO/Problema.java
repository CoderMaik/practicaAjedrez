package POO;

import Piezas.Caballo;
import Piezas.*;
import static Piezas.Pieza.nuevaPieza;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Problema {
    private HashSet<Usuario> intentado_por;
    private HashSet<Usuario> resuelto_por;
    private double porcentaje_exito;
    private String jugada_ganadora;
    private Tablero tab;

    public Problema(){
        this.resuelto_por = new HashSet<>();
        this.intentado_por = new HashSet<>();
        this.porcentaje_exito = 0;
    }
    
    public Problema(File fichero) throws IOException {
        this.intentado_por= new HashSet<>();
        this.resuelto_por= new HashSet<>();
        this.porcentaje_exito=0;
        tab = new Tablero();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            int fila=7;
            int col;
            Pieza p = null;
            while(fila>=0){
                col=0;
                String line = br.readLine();
                line = line.replaceAll(",","");
                for (int i = 0; i < line.length(); i++) {
                    char proc = line.charAt(i);
                    if(proc!='v'&&proc!='V'&&proc!='B'&&proc!='b'&&proc!='N'&&proc!='n'){
                        p=nuevaPieza(proc);
                    }else{
                        if(proc=='B'||proc!='b')
                            p.setColor(Color.BLANCO);
                        else if(proc=='N'||proc=='n')
                            p.setColor(Color.NEGRO);    
                    }
                    tab.getMapa()[fila][col].addPieza(p);
                    col++;
                }fila--;
            }this.jugada_ganadora=br.readLine();
        }catch(IOException io){
            System.out.println("ERROR DE LECTURA DE PROBLEMA");
        }
    }

    public boolean comprobarSizeTablero(Tablero tab){
        int size = tab.getMapa().length;
        boolean columnas = false;
        for(int i = 0; i < size + 1; i ++ ) {
            if (tab.getMapa()[i].length == 8)
                columnas = true;
            else 
                return false;
        }
        return (tab.getMapa().length == 8) && (columnas = true);
    }
    public boolean checkSol(String s){
        return (s.equals(this.jugada_ganadora));
    }
    public Tablero getTablero(){
        return this.tab;
    }

    public void setTab(Tablero tab) {
        this.tab = tab;
    }

    public HashSet<Usuario> getResuelto_por() {return resuelto_por;}
    
    public HashSet<Usuario> getIntentado_por(){return this.intentado_por;}
    public void setResuelto_por(HashSet<Usuario> resuelto_por) {
        this.resuelto_por = resuelto_por;
    }
    
    public void updatePorcentajeExitos(){
        this.porcentaje_exito = (double) this.resuelto_por.size() / this.intentado_por.size() * 100;
    }

    public double getPorcentaje_exito() {
        return porcentaje_exito;
    }

    public void setPorcentaje_exito(double porcentaje_exito) {
        this.porcentaje_exito = porcentaje_exito;
    }

    public String getJugada_ganadora() {
        return jugada_ganadora;
    }

    public void setJugada_ganadora(String jugada_ganadora) {
        this.jugada_ganadora = jugada_ganadora;
    }
    
    //PARTE OPCIONAL - JAQUE MATE
    public boolean checkMov(String s) {
        //NO SE PUEDEN USAR SWITCH CON EL MATCHER
        char c; //letra de Pieza
        Casilla destino;
        Pieza p;
        //Notaciones del jaque mate
        s = s.replace('+','0');
        s = s.replaceAll("#","00");
        if(s.matches("[a-h][1-8]00")){ //MOVER PEON
            c = 'P';
            destino = tab.getCasilla(s.charAt(0), Character.getNumericValue(s.charAt(1))-1);
            p = tab.moveR(c,destino);
            return saveAndTryCheckMate(destino,p);
        }else if(s.matches("[a-h]x[a-h][1-8]00")){ //PEON COMER
            c = 'P';
            destino =tab.getCasilla(s.charAt(2), Character.getNumericValue(s.charAt(3))-1);
            p = tab.moveR(c,destino,s.charAt(0));
            return !((!destino.esLibre() && !destino.esComible(Color.NEGRO)) || !saveAndTryCheckMate(destino,p));
        }else if(s.matches("[ACDRT][a-h][1-8]00")){ //MOVER PIEZA
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(1), Character.getNumericValue(s.charAt(2))-1);
            p = tab.moveR(c,destino);
            return saveAndTryCheckMate(destino,p);
        }else if(s.matches("[ACDRT]x[a-h][1-8]00")){ // COMER PIEZA
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(2), Character.getNumericValue(s.charAt(3))-1);
            p = tab.moveR(c,destino);
            return saveAndTryCheckMate(destino,p);
        }else if(s.matches("[ACDRT][a-h]x[a-h][1-8]00")){ // COMER PIEZA VARIOS
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(3),Character.getNumericValue(s.charAt(4))-1);
            p = tab.moveR(c,destino,s.charAt(1));
            return saveAndTryCheckMate(destino,p);
        }else if(s.matches("[ACDRT][a-h][a-h][1-8]00")){ //MOVER PIEZA VARIOS
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(3),Character.getNumericValue(s.charAt(4))-1);
            p = tab.moveR(c,destino,s.charAt(1));
            return saveAndTryCheckMate(destino,p);
        }else
        return false;
    }
    public boolean saveAndTryCheckMate(Casilla destino, Pieza p){
        Casilla origen;
        Pieza comida = null;
        Boolean comido = false;
        if(p!=null){
                //Guardar estado actual
               origen = p.getCas();
               if(!destino.esLibre()){
                    comida = destino.getContenido();
                    comido=true;
               }
               //Mover pieza
               p.getCas().removePieza();
               destino.addPieza(p);
               //comprobar jaquemate
               if(!checkMate()){ //NO GANADOR
                   //Volver al estado original
                   if(comido)
                        destino.addPieza(comida);
                   else
                       destino.removePieza();
                   origen.addPieza(p);
                   return false;
               }else{ //GANADOR
                   //Volver al estado original
                   if(comido)
                        p.getCas().addPieza(comida);
                   origen.addPieza(p);
                   return true;
               }
        }else
         return false;
    }
    public boolean checkMate(){ //ME FALTÓ LA CONDICIÓN DE LA LINEA DE VISIÓN (Y LA DEL ENROQUE QUE NO SE PUEDE HACER)
        Pieza r = tab.getRey(Color.NEGRO);
        //Si el rey tiene escapatoria o mi rey está amenazado jaque mate falla
        if(r.reyEscapatoria() || (tab.getRey(Color.BLANCO).getCas().amenazadaPor(tab, Color.NEGRO)>0))
            return false;
        else 
            //Busco mitigar alguna de las amenazas blancas
            return !r.mitigarUnaAmenaza();
    }
/*Formato PGN
    Letra de pieza
    Columna(solo aparece si hay varias piezas que puedan mover ahí)
    x (aparece solo si se come una pieza)
    Casilla destino
    ++ (jaquemate)
    
  Condiciones de jaque mate:
    Si el rey tiene escapatoria o mi rey está amenazado return false 
        si no: miro las casillas amenazadas por una sola figura blanca
            si me puedo comer a alguna de esas figuras lo hago y
                 si reyEscapatoria entonces return false
                 si no entonces vuelvo atrás
        si no: identifico la linea de visión que tienen
                 si puedo bloquearla con alguna pieza lo hago y 
                    si reyEscapatoria entonces return false
                    si no entonces vuelvo atrás
        si no: probaría a esconderme con enroque (no se puede comprobar)
    return true*/
}
