package Piezas;

import POO.Casilla;
import POO.Tablero;

public class Caballo extends Pieza {
    private final char simbolo = 'C';

    public Caballo() {}

    public boolean mover(Casilla origen, Casilla destino) {
        throw new RuntimeException("Not implemented yet");
    }
     /*private boolean mov(Casilla origen,Casilla destino){
        //Comprobaciones de siempre.
        origen(a,1);
        primer camino:
        a++; -> int ocupado = ocupada();
        b++; -> int ocupado = 1 && ocupada()==true -> return bloqueado1;
        1++; opcional
        return true;

        if bloqueado1 entonces segundo camino:
        1++; -> int ocupado = ocupada();
        a++; -> int ocupado = 1 && ocupada()==true -> return false;
        b++; opcional
        return true;
        int movHorizontal = destino.getCoorX() - origen.getCoorX();
        int movVertical = destino.getCoorY() - origen.getCoorY();
    }*/
}
