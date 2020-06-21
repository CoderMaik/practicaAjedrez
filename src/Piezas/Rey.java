package Piezas;

import POO.Casilla;

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
    public char getLetra (){return this.simbolo;}
}
