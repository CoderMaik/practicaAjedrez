package POO;

import Piezas.Caballo;
import Piezas.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problema {

    private int resuelto_por;
    private double porcentaje_exito;
    private String jugada_ganadora;
    private Tablero tab;
    
    public Problema(){
        this.resuelto_por = 0;
        this.porcentaje_exito = 0;
    }
    
    public Problema(File fichero) throws IOException {
        this.resuelto_por = 0;
        this.porcentaje_exito = 0;
        boolean rey_blanco = false;
        boolean rey_negro = false;
        int cPeonesBlancos = 0;
        int cPeonesNegros = 0;
        int contPiezasT = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            int charLeido = br.read();
            tab = new Tablero();
            int columna = 0;
            int fila = 7;
            while (charLeido != -1 || fila>=0) {
                char caracter = ((char) charLeido);
                if (fila != 0) {
                    switch (caracter) {
                        case 'V':
                            tab.getMapa()[fila][columna] = null; // no metemos pieza
                        case ',':
                            if (columna == 8) {
                                columna = 0;
                                fila--;
                            } else 
                                columna++;
                        case 'C':
                            Pieza caballo = new Caballo();
                            tab.getMapa()[fila][columna].addPieza(caballo);
                            caballo.setCas(tab.getMapa()[fila][columna]);
                            caballo.setTab(tab);
                            caracter = ((char) br.read());
                            contPiezasT += 1;
                            switch (caracter) {
                                case 'B':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.BLANCO);
                                    break;
                                case 'N':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.NEGRO);
                                    break;
                                default:
                                    throw new IOException("Formato incorrecto");
                            }break;
                        case 'P':
                            Pieza peon = new Peon();
                            tab.getMapa()[fila][columna].addPieza(peon);
                            peon.setCas(tab.getMapa()[fila][columna]);
                            peon.setTab(tab);
                            caracter = ((char) br.read());
                            contPiezasT += 1;
                            switch (caracter) {
                                case 'B':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.BLANCO);
                                    cPeonesBlancos += 1;
                                    break;
                                case 'N':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.NEGRO);
                                    cPeonesNegros += 1;
                                    break;
                                default:
                                    throw new IOException("Formato incorrecto");
                            }break;
                        case 'D':
                            Pieza dama = new Dama();
                            tab.getMapa()[fila][columna].addPieza(dama);
                            dama.setCas(tab.getMapa()[fila][columna]);
                            dama.setTab(tab);
                            caracter = ((char) br.read());
                            contPiezasT += 1;
                            switch (caracter) {
                                case 'B':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.BLANCO);
                                    break;
                                case 'N':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.NEGRO);
                                    break;
                                default:
                                    throw new IOException("Formato incorrecto");
                            }break;
                        case 'A':
                            Pieza alfil = new Alfil();
                            tab.getMapa()[fila][columna].addPieza(alfil);
                            alfil.setCas(tab.getMapa()[fila][columna]);
                            alfil.setTab(tab);
                            caracter = ((char) br.read());
                            contPiezasT += 1;
                            switch (caracter) {
                                case 'B':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.BLANCO);
                                    break;
                                case 'N':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.NEGRO);
                                    break;
                                default:
                                    throw new IOException("Formato incorrecto");
                            }break;
                        case 'R':
                            Pieza rey = new Rey();
                            tab.getMapa()[fila][columna].addPieza(rey);
                            rey.setCas(tab.getMapa()[fila][columna]);
                            rey.setTab(tab);
                            caracter = ((char) br.read());
                            contPiezasT += 1;
                            switch (caracter) {
                                case 'B':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.BLANCO);
                                    rey_blanco = true;
                                    break;
                                case 'N':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.NEGRO);
                                    rey_negro = true;
                                    break;
                                default:
                                    throw new IOException("Formato incorrecto");
                            }break;
                        case 'T':
                            Pieza torre = new Torre();
                            tab.getMapa()[fila][columna].addPieza(torre);
                            torre.setCas(tab.getMapa()[fila][columna]);
                            torre.setTab(tab);
                            caracter = ((char) br.read());
                            contPiezasT += 1;
                            switch (caracter) {
                                case 'B':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.BLANCO);
                                    break;
                                case 'N':
                                    tab.getMapa()[fila][columna].getContenido().setColor(Color.NEGRO);
                                    break;
                                default:
                                    throw new IOException("Formato incorrecto");
                            }break;
                        default:
                            throw new IOException("Error al leer contenido");
                    }
                    charLeido = br.read();
                } else {
                    //ULTIMA FILA matches solucion 
                    jugada_ganadora = br.readLine();
                    if((!rey_blanco && !rey_negro)
                            ||(cPeonesBlancos > 8) && (cPeonesNegros > 8)
                            ||(contPiezasT > 32)
                            ||(!comprobarSizeTablero(tab)))
                        throw new IOException("Formato incorrecto");                    
                    fila--; //ya termino, fila = -1
                }
            }
        } catch (IOException ioEx) {
            this.tab = null;
            this.jugada_ganadora = null;
            System.out.println(ioEx.getMessage());
        }
    }

    public boolean comprobarSizeTablero(Tablero tab){
        int size = tab.getMapa().length;
        boolean columnas = false;
        for(int i = 0; i < size + 1; i ++ ) {
            if (tab.getMapa()[i].length == 8) {
                columnas = true;
            } else {
                return false;
            }
        }
        return (tab.getMapa().length == 8) && (columnas = true);
    }

    public boolean checkSol(String s){
        return (s.equals(this.jugada_ganadora));
    }
    public Tablero getTablero(){
        return this.tab;
    }

    public int getResuelto_por() {
        return resuelto_por;
    }

    public void setResuelto_por(int resuelto_por) {
        this.resuelto_por = resuelto_por;
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
    
    private boolean checkMov(String s) throws Exception{
        //NO SE PUEDEN USAR SWITCH CON EL MATCHER
        char c; //letra de Pieza
        Casilla destino;
        Pieza p;
        if(s.matches("[a-h][1-8]++")){ //MOVER PEON 
            c = 'P';
            destino = tab.getCasilla(s.charAt(0), Character.getNumericValue(s.charAt(1)));
            p = tab.moveR(c,destino);
            return saveStatus(destino,p);
        }else if(s.matches("[a-h]x[a-h][1-8]++")){ //PEON COMER
            c = 'P';
            destino =tab.getCasilla(s.charAt(2), Character.getNumericValue(s.charAt(3)));
            p = tab.moveR(c,destino,s.charAt(0));
            return !((!destino.esLibre() && !destino.esComible(Color.NEGRO)) || !saveStatus(destino,p));
        }else if(s.matches("[ACDRT][a-h][1-8]++")){ //MOVER PIEZA 
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(1), Character.getNumericValue(s.charAt(2)));
            p = tab.moveR(c,destino);
            return saveStatus(destino,p);
        }else if(s.matches("[ACDRT]x[a-h][1-8]++")){ // COMER PIEZA
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(2), Character.getNumericValue(s.charAt(3)));
            p = tab.moveR(c,destino);
            return saveStatus(destino,p);
        }else if(s.matches("[ACDRT][a-h]x[a-h][1-8]++")){ // COMER PIEZA VARIOS
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(3),Character.getNumericValue(s.charAt(4)));
            p = tab.moveR(c,destino,s.charAt(1));
            return saveStatus(destino,p);
        }else if(s.matches("[ACDRT][a-h][a-h][1-8]++")){ //MOVER PIEZA VARIOS
            c = s.charAt(0);
            destino = tab.getCasilla(s.charAt(3),Character.getNumericValue(s.charAt(4)));
            p = tab.moveR(c,destino,s.charAt(1));
            return saveStatus(destino,p);
        }else
            return false;
    }
    public boolean saveStatus(Casilla destino, Pieza p){
        Casilla origen;
        Pieza comida;
        if(p!=null){
                //Guardar estado actual
               origen = p.getCas();
               comida = destino.getContenido();
               //Mover pieza
               p.getCas().removePieza();
               p.setCas(destino);
               destino.addPieza(p);
               //comprobar jaquemate
               if(!checkMate()){
                   //Volver al estado original
                   p.getCas().addPieza(comida);
                   p.setCas(origen);
                   origen.addPieza(p);
                   return false;
               }else{ //CHICKEN WINNER
                   //Volver al estado original
                   p.getCas().addPieza(comida);
                   p.setCas(origen);
                   origen.addPieza(p);
                   return true;
               }
            }else
                return false;
    }
    public boolean checkMate(){
        throw new RuntimeException("not implemented yet");
    }
/*Formato PGN
    Letra de pieza
    Columna(solo aparece si hay varias piezas que puedan mover ahí)
    x (aparece solo si se come una pieza)
    Casilla destino
    ++ (jaquemate)
    */
}
