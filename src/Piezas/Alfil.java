package Piezas;

import POO.Casilla;

public class Alfil extends Pieza {
    private final char simbolo = 'A';

    public Alfil() {}
    public char getLetra (){
        return this.simbolo;
    }
    
    public boolean mover(Casilla origen, Casilla destino) {
        if(!origenValido(origen) || !inValido(destino) || !movValido(origen,destino))
            return false;
        return submover(origen,destino);
    }

    private boolean submover(Casilla origen, Casilla destino) {
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor())))
            return true;
        else if(!origen.esLibre())
            return false;
        //Casos recursivos
        if(destino.getCoorX()-origen.getCoorX()>0 && destino.getCoorY()-origen.getCoorY()>0) //UPRIGHT
            return submover(tab.getCasillaXY(origen.getCoorX()+1,origen.getCoorY()+1),destino);
        else if (destino.getCoorX()-origen.getCoorX()<0 && destino.getCoorY()-origen.getCoorY()>0) //UPLEFT
            return submover(tab.getCasillaXY(origen.getCoorX()-1,origen.getCoorY()+1),destino);
        else if (destino.getCoorX()-origen.getCoorX()<0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNLEFT
            return submover(tab.getCasillaXY(origen.getCoorX()-1,origen.getCoorY()-1),destino);
        else if (destino.getCoorX()-origen.getCoorX()>0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNRIGHT
            return submover(tab.getCasillaXY(origen.getCoorX()+1,origen.getCoorY()-1),destino);
        else
            return false;
    }

    private boolean movValido(Casilla origen, Casilla destino){ //MovHorizontal = MovVertical
        return (!origen.equals(destino) && Math.abs(destino.getCoorY()-origen.getCoorY()) == Math.abs(destino.getCoorX()-origen.getCoorX()));
    }
}
