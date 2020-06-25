package Piezas;

import POO.Casilla;

public class Alfil extends Pieza {
    private final char simbolo = 'A';

    public Alfil() {}
    
    @Override
    public boolean mover(Casilla origen, Casilla destino) {
        if(!origenValido(origen) || !inValido(destino) || !movValido(origen,destino))
            return false;
        return submover(origen,destino);
    }

    private boolean submover(Casilla origen, Casilla destino) {
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor())))
            return true;
        else if(!origen.equals(this.getCas()) && !origen.esLibre())
            return false;
        //Casos recursivos
        if(destino.getCoorXi()-origen.getCoorXi()>0 && destino.getCoorY()-origen.getCoorY()>0) //UPRIGHT
            return submover(tab.getCasillaXY(origen.getCoorXi()+1,origen.getCoorY()+1),destino);
        else if (destino.getCoorXi()-origen.getCoorXi()<0 && destino.getCoorY()-origen.getCoorY()>0) //UPLEFT
            return submover(tab.getCasillaXY(origen.getCoorXi()-1,origen.getCoorY()+1),destino);
        else if (destino.getCoorXi()-origen.getCoorXi()<0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNLEFT
            return submover(tab.getCasillaXY(origen.getCoorXi()-1,origen.getCoorY()-1),destino);
        else if (destino.getCoorXi()-origen.getCoorXi()>0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNRIGHT
            return submover(tab.getCasillaXY(origen.getCoorXi()+1,origen.getCoorY()-1),destino);
        else
            return false;
    }

    private boolean movValido(Casilla origen, Casilla destino){ //MovHorizontal = MovVertical
        return (!origen.equals(destino) && Math.abs(destino.getCoorY()-origen.getCoorY()) == Math.abs(destino.getCoorX()-origen.getCoorX()));
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
