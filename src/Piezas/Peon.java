package Piezas;

import POO.Casilla;

public class Peon extends Pieza {
    private final char simbolo = 'P';

    public Peon() {}

    public boolean mover(Casilla origen, Casilla destino) {
        if (!inValido(destino) || !origenValido(origen))
            return false;
        if (origen.getCoorX()-destino.getCoorX() == 0){ //Movimiento normal
            if (!destino.isLibre())
                return false;
            else if ((this.getColor()==Color.BLANCO && tab.getCasilla(cas.getCoorX(),cas.getCoorY()+1)==destino)
                    || (this.getColor()==Color.NEGRO && tab.getCasilla(cas.getCoorX(),cas.getCoorY()-1)==destino))
                        return true;
        }else{ //Movimiento para comer
            if ((this.getColor()==Color.BLANCO && (destino.getCoorY()-origen.getCoorY())>0)||
                (this.getColor()==Color.NEGRO && (destino.getCoorY()-origen.getCoorY())<0))
                    return true;
        }return false;
    }
}
