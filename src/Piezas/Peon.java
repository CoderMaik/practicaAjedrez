package Piezas;

import POO.Casilla;
import static POO.Tablero.checkCasilla;

public class Peon extends Pieza {
    private final char simbolo = 'P';

    public Peon() {}
    
    @Override
    public boolean mover(Casilla origen, Casilla destino) {
        if (!origenValido(origen))
            return false;
        if (origen.getCoorXi()-destino.getCoorXi() == 0){ //Movimiento normal
            if (!destino.esLibre())
                return false;
            else if ((this.getColor()==Color.BLANCO && checkCasilla(cas.getCoorX(),cas.getCoorY()+1) && tab.getCasilla(cas.getCoorX(),cas.getCoorY()+1)==destino)
                    || (this.getColor()==Color.NEGRO && checkCasilla(cas.getCoorX(),cas.getCoorY()-1) && tab.getCasilla(cas.getCoorX(),cas.getCoorY()-1)==destino))
                return true;
        }else{ //Movimiento para comer falta es comible
            if ((this.getColor()==Color.BLANCO && (!destino.esLibre() && destino.esComible(Color.NEGRO)) && (destino.getCoorY()-origen.getCoorY())==1)||
                    (this.getColor()==Color.NEGRO && (!destino.esLibre() && destino.esComible(Color.BLANCO)) && (destino.getCoorY()-origen.getCoorY())==-1))
                return true;
        }return false;
    }
    @Override
    public char getLetra (){return this.simbolo;}
    @Override
    public boolean reyEscapatoria() {
        throw new RuntimeException("No es un Rey");
    }
    @Override
    public boolean mitigarUnaAmenaza() {
        throw new RuntimeException("No es un Rey");
    }
}
