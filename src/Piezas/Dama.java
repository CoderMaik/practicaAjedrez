package Piezas;

import POO.Casilla;

public class Dama extends Pieza {
    private final char simbolo = 'D';

    public Dama() {}
    public char getLetra (){
        return this.simbolo;
    }

    public boolean mover(Casilla origen, Casilla destino) {
        if(!origenValido(origen) || !inValido(destino) || !movValido(origen,destino))
            return false;
        if(origen.getCoorX()-destino.getCoorX()==0 || origen.getCoorY()-destino.getCoorY()==0)
            return submoverAsTorre(origen,destino);
        else if(Math.abs(destino.getCoorY()-origen.getCoorY()) == Math.abs(destino.getCoorX()-origen.getCoorX()))
            return submoverAsAlfil(origen,destino);
        else
            return false;
    }

    private boolean submoverAsTorre(Casilla origen, Casilla destino) {
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor())))
            return true;
        else if(!origen.esLibre())
            return false;
        //Casos recursivos
        int movHorizontal = origen.getCoorX()-destino.getCoorX();
        int movVertical = origen.getCoorY()-destino.getCoorY();
        if(movVertical == 0 && movHorizontal<0) //movimiento horizontal hacia derecha
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorX()+1,origen.getCoorY()),destino));
        else if(movVertical == 0 && movHorizontal>0) //movimiento horizontal izquierda
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorX()-1,origen.getCoorY()),destino));
        else if(movHorizontal == 0 && movVertical<0) //movimiento vertical hacia arriba
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorX(),origen.getCoorY()+1),destino));
        else if(movHorizontal == 0 && movVertical>0) //movimiento vertical hacia abajo
            return(submoverAsTorre(tab.getCasillaXY(origen.getCoorX(),origen.getCoorY()-1),destino));
        else
            return false;
    }

    private boolean submoverAsAlfil(Casilla origen, Casilla destino) {
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor())))
            return true;
        else if(!origen.esLibre())
            return false;
        //Casos recursivos
        if(destino.getCoorX()-origen.getCoorX()>0 && destino.getCoorY()-origen.getCoorY()>0) //UPRIGHT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorX()+1,origen.getCoorY()+1),destino);
        else if (destino.getCoorX()-origen.getCoorX()<0 && destino.getCoorY()-origen.getCoorY()>0) //UPLEFT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorX()-1,origen.getCoorY()+1),destino);
        else if (destino.getCoorX()-origen.getCoorX()<0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNLEFT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorX()-1,origen.getCoorY()-1),destino);
        else if (destino.getCoorX()-origen.getCoorX()>0 && destino.getCoorY()-origen.getCoorY()<0) //DOWNRIGHT
            return submoverAsAlfil(tab.getCasillaXY(origen.getCoorX()+1,origen.getCoorY()-1),destino);
        else
            return false;
    }

    private boolean movValido(Casilla origen, Casilla destino) {
        return (!origen.equals(destino) && origen.getCoorX()-destino.getCoorX()==0 || origen.getCoorY()-destino.getCoorY()==0)
                ||(!origen.equals(destino) && Math.abs(destino.getCoorY()-origen.getCoorY()) == Math.abs(destino.getCoorX()-origen.getCoorX()));
    }
}
