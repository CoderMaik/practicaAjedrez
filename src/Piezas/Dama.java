package Piezas;

import POO.Casilla;

public class Dama extends Pieza {
    private final char simbolo = 'D';

    public Dama() {}

    @Override
    public boolean mover(Casilla origen, Casilla destino) {
        if(!origenValido(origen) || !movValido(origen,destino))
            return false;
        if(origen.getCoorXi()-destino.getCoorXi()==0 || origen.getCoorY()-destino.getCoorY()==0)
            return submoverAsTorre(origen,destino);
        else if(Math.abs(destino.getCoorY()-origen.getCoorY()) == Math.abs(destino.getCoorXi()-origen.getCoorXi()))
            return submoverAsAlfil(origen,destino);
        else
            return false;
    }

    private boolean submoverAsTorre(Casilla origen, Casilla destino) {
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor())))
            return true;
        else if(!origen.equals(this.getCas()) && !origen.esLibre())
            return false;
        //Casos recursivos
        int movHorizontal = origen.getCoorXi()-destino.getCoorXi();
        int movVertical = origen.getCoorY()-destino.getCoorY();
        if(movVertical == 0 && movHorizontal<0) //movimiento horizontal hacia derecha
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorXi()+1,origen.getCoorY()),destino));
        else if(movVertical == 0 && movHorizontal>0) //movimiento horizontal izquierda
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorXi()-1,origen.getCoorY()),destino));
        else if(movHorizontal == 0 && movVertical<0) //movimiento vertical hacia arriba
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorXi(),origen.getCoorY()+1),destino));
        else if(movHorizontal == 0 && movVertical>0) //movimiento vertical hacia abajo
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorXi(),origen.getCoorY()-1),destino));
        else
            return false;
    }

    private boolean submoverAsAlfil(Casilla origen, Casilla destino) {
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor())))
            return true;
        else if(!origen.equals(this.getCas()) && !origen.esLibre())
            return false;
        
        //Casos recursivos
        if(destino.getCoorXi()-origen.getCoorXi()>0 && destino.getCoorY()-origen.getCoorY()>0) //UPRIGHT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorXi()+1,origen.getCoorY()+1),destino);
        else if (destino.getCoorXi()-origen.getCoorXi()<0 && destino.getCoorY()-origen.getCoorY()>0) //UPLEFT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorXi()-1,origen.getCoorY()+1),destino);
        else if (destino.getCoorXi()-origen.getCoorXi()<0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNLEFT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorXi()-1,origen.getCoorY()-1),destino);
        else if (destino.getCoorXi()-origen.getCoorXi()>0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNRIGHT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorXi()+1,origen.getCoorY()-1),destino);
        else
            return false;
    }

    private boolean movValido(Casilla origen, Casilla destino) {
        return (!origen.equals(destino) && origen.getCoorXi()-destino.getCoorXi()==0 || origen.getCoorY()-destino.getCoorY()==0)
                ||(!origen.equals(destino) && Math.abs(destino.getCoorY()-origen.getCoorY()) == Math.abs(destino.getCoorXi()-origen.getCoorXi()));
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
