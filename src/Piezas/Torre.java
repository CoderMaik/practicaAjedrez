package Piezas;

import POO.Casilla;

public class Torre extends Pieza {
    private final char simbolo = 'T';
    public Torre() {}

    public boolean mover(Casilla origen, Casilla destino) {
        if(!origenValido(origen) || !inValido(destino) || !movValido(origen,destino))
            return false;
        return submover(origen,destino);
    }
    private boolean submover(Casilla origen, Casilla destino){ //Método recursivo
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor())))
            return true;
        else if(!origen.esLibre())
            return false;
        //Casos recursivos
        int movHorizontal = origen.getCoorX()-destino.getCoorX();
        int movVertical = origen.getCoorY()-destino.getCoorY();
        if(movVertical == 0 && movHorizontal<0) //movimiento horizontal hacia derecha
            return(submover(tab.getCasillaXY(origen.getCoorX()+1,origen.getCoorY()),destino));
        else if(movVertical == 0 && movHorizontal>0) //movimiento horizontal izquierda
            return(submover(tab.getCasillaXY(origen.getCoorX()-1,origen.getCoorY()),destino));
        else if(movHorizontal == 0 && movVertical<0) //movimiento vertical hacia arriba
            return(submover(tab.getCasillaXY(origen.getCoorX(),origen.getCoorY()+1),destino));
        else if(movHorizontal == 0 && movVertical>0) //movimiento vertical hacia abajo
            return(submover(tab.getCasillaXY(origen.getCoorX(),origen.getCoorY()-1),destino));
        else
            return false;
    }
    private boolean movValido(Casilla origen, Casilla destino){
        return(!origen.equals(destino) && origen.getCoorX()-destino.getCoorX()==0 || origen.getCoorY()-destino.getCoorY()==0);
    }
    
    public char getLetra (){return this.simbolo;}
}
