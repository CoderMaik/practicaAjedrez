package Piezas;

import POO.Casilla;

public class Torre extends Pieza {
    private final char simbolo = 'T';
    public Torre() {}

    @Override
    public boolean mover(Casilla origen, Casilla destino) { 
        if(!origenValido(origen) || !inValido(destino) || !movValido(origen,destino))
            return false;
        //se mueve una vez y luego empiezan las comprobaciones
        int movHorizontal = origen.getCoorXi()-destino.getCoorXi();
        int movVertical = origen.getCoorY()-destino.getCoorY();
        if(movVertical == 0 && movHorizontal<0){ //movimiento horizontal hacia derecha
            return(submover(tab.getCasillaXY(origen.getCoorXi()+1,origen.getCoorY()),destino));
        }else if(movVertical == 0 && movHorizontal>0) //movimiento horizontal izquierda
            return(submover(tab.getCasillaXY(origen.getCoorXi()-1,origen.getCoorY()),destino));
        else if(movHorizontal == 0 && movVertical<0) //movimiento vertical hacia arriba
            return(submover(tab.getCasillaXY(origen.getCoorXi(),origen.getCoorY()+1),destino));
        else if(movHorizontal == 0 && movVertical>0) //movimiento vertical hacia abajo
            return(submover(tab.getCasillaXY(origen.getCoorXi(),origen.getCoorY()-1),destino));
        else
            return false;
    }
    private boolean submover(Casilla origen, Casilla destino){ //Método recursivo     
        //Casos base
        if(origen.equals(destino) && (origen.esLibre() || origen.esComible(this.getOpColor()))){
            System.out.println("BASE TRUE");
            return true;
        }else if(!origen.equals(destino) && !origen.esLibre()){
            System.out.println("BASE FALSE");
            return false;
        }
        //Casos recursivos
        int movHorizontal = origen.getCoorXi()-destino.getCoorXi();
        int movVertical = origen.getCoorY()-destino.getCoorY();
        if(movVertical == 0 && movHorizontal<0){ //movimiento horizontal hacia derecha
            return(submover(tab.getCasillaXY(origen.getCoorXi()+1,origen.getCoorY()),destino));
        }else if(movVertical == 0 && movHorizontal>0) //movimiento horizontal izquierda
            return(submover(tab.getCasillaXY(origen.getCoorXi()-1,origen.getCoorY()),destino));
        else if(movHorizontal == 0 && movVertical<0) //movimiento vertical hacia arriba
            return(submover(tab.getCasillaXY(origen.getCoorXi(),origen.getCoorY()+1),destino));
        else if(movHorizontal == 0 && movVertical>0) //movimiento vertical hacia abajo
            return(submover(tab.getCasillaXY(origen.getCoorXi(),origen.getCoorY()-1),destino));
        else
            return false;
    }
    private boolean movValido(Casilla origen, Casilla destino){
        return(!origen.equals(destino) && origen.getCoorXi()-destino.getCoorXi()==0 || origen.getCoorY()-destino.getCoorY()==0);
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
