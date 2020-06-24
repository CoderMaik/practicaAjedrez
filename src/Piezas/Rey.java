package Piezas;

import POO.Casilla;
import POO.Tablero;

public class Rey extends Pieza {
    private final char simbolo = 'R';

    public Rey() {}

    public boolean mover(Casilla origen, Casilla destino) {
        if (!inValido(destino) || !origenValido(origen) || !movValido(origen,destino) || (!destino.esLibre() && !destino.esComible(this.getOpColor())))
            return false;
        else
            return true;
    }
    private boolean movValido(Casilla origen, Casilla destino){
        return(!origen.equals(destino) &&
                Math.abs(destino.getCoorX()-origen.getCoorX())<=1 &&
                    Math.abs(destino.getCoorY()-origen.getCoorY())<=1);
    }
    public boolean reyEscapatoria(){
        int x = Tablero.getRowInt(this.cas.getCoorX());
        int y = cas.getCoorY();
        return (Tablero.checkCasilla(x,y) && this.tab.getCasillaXY(x,y).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x+1,y) && this.tab.getCasillaXY(x+1,y).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x-1,y) && this.tab.getCasillaXY(x-1,y).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x,y+1) && this.tab.getCasillaXY(x,y+1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x,y-1) && this.tab.getCasillaXY(x,y-1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x+1,y+1) && this.tab.getCasillaXY(x+1,y+1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x+1,y-1) && this.tab.getCasillaXY(x+1,y-1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x-1,y+1) && this.tab.getCasillaXY(x-1,y+1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x-1,y-1) && this.tab.getCasillaXY(x-1,y-1).amenazadaPor(tab,this.getOpColor())==0);
    }

    public char getLetra (){return this.simbolo;}
}
