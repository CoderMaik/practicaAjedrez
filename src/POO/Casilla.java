package POO;

import Piezas.Color;
import Piezas.Pieza;

public class Casilla {
    private char coorX;
    private int coorY;
    private boolean libre;
    private Pieza contenido;

    public Casilla() {
    }

    public Casilla(char x, int y) {
        coorX = x;
        coorY = y;
    }

    public void addPieza(Pieza p) {
        libre = false;
        this.contenido = p;
    }

    public void removePieza() {
        this.contenido = null; //Creo que es opcional
        libre = true;
    }
    public int amenazadaPor(Tablero tab, Color color){ //Devuelve el numero de piezas amenazando la casilla
        int cont=0;
        for(int fil=7;fil>=0;fil--){
            for(int col=0;col<8;col++){
                Pieza p = tab.getMapa()[fil][col].getContenido();
                if(p.getColor().equals(color) && p.mover(tab.getCasillaXY(fil,col),this))
                    cont++;
            }
        }return cont;
    }

    public Pieza getContenido() {return this.contenido;}
    public char getCoorX() {return coorX;}
    public int getCoorY() {return coorY;}
    public boolean esLibre() {return libre;}
    public boolean esComible(Color color) {
        return (color == contenido.getColor());
    }
}
