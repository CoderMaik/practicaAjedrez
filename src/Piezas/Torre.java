package Piezas;

import POO.Casilla;
import POO.Tablero;

public class Torre extends Pieza {
    private final char simbolo = 'T';

    public Torre() {}

    public boolean mover(Casilla origen, Casilla destino) {
        if(!origenValido(origen) || !destinoValido(destino))
            return false;
        return submover(origen,destino);
    }
    private boolean submover(Casilla origen, Casilla destino){ //Método recursivo
        //Casos base
        if(origen.equals(destino))
            return true;
        else if(!origen.isLibre())
            return false;
        //Casos recursivos
        int movHorizontal = origen.getCoorX()-destino.getCoorX();
        int movVertical = origen.getCoorY()-destino.getCoorY();
        if(movVertical == 0 && movHorizontal<0) //movimiento horizontal hacia arriba
            return(submover(tab.getCasillaXY(origen.getCoorX()+1,origen.getCoorY()),destino));
        else if(movVertical == 0 && movHorizontal>0) //movimiento horizontal hacia abajo
                return(submover(tab.getCasillaXY(origen.getCoorX()-1,origen.getCoorY()),destino));
        else if(movHorizontal == 0 && movVertical<0) //movimiento vertical hacia arriba
            return(submover(tab.getCasillaXY(origen.getCoorX(),origen.getCoorY()+1),destino));
        else if(movHorizontal == 0 && movVertical>0) //movimiento vertical hacia abajo
            return(submover(tab.getCasillaXY(origen.getCoorX(),origen.getCoorY()-1),destino));
        return false;
    }
    /*
    contador columna = 0
    contador fila = 0
    contador index = 0

    while(string[index] == null){
        string[index]
        if string[index] = V

        else if string[index] = ,
            if columna = 8
                columna = 1
                fila + 1
            else
                columna + 1
        else if string[index] = B / N
            tablero[fila][columna].setColor( B/N )
        else
            new pieza( del tipo string[index])
            tablero[fila][columna] <- pieza
        index + 1
    }
     */





}
