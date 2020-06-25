package Piezas;

import POO.Casilla;
import static POO.Tablero.checkCasilla;

public class Caballo extends Pieza {
    private final char simbolo = 'C';

    public Caballo() {}

    @Override
    public boolean mover(Casilla o, Casilla d) {
       int movH = d.getCoorXi()-o.getCoorXi();
       int movV = d.getCoorY()-o.getCoorY();
       int i = 0;
       if(!origenValido(o) || !inValido(d) || !movValido(o,d))
            return false;
       if(movH>0 && movV>0)
           return checkCasilla(o.getCoorXi()+1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()+1, o.getCoorY()),d,movH-1,movV,i) 
                   || checkCasilla(o.getCoorXi(), o.getCoorY()+1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()+1),d,movH,movV-1,i);
       else if(movH>0 && movV<0)
           return checkCasilla(o.getCoorXi()+1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()+1, o.getCoorY()),d,movH-1,movV,i) 
                   || checkCasilla(o.getCoorXi(), o.getCoorY()-1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()-1),d,movH,movV+1,i);
       else if(movH<0 && movV>0)
           return checkCasilla(o.getCoorXi()-1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()-1, o.getCoorY()),d,movH+1,movV,i) 
                   || checkCasilla(o.getCoorXi(), o.getCoorY()+1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()+1),d,movH,movV-1,i);
       else //movH<0 && movV<0
           return checkCasilla(o.getCoorXi()-1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()-1, o.getCoorY()),d,movH+1,movV,i) 
                   || checkCasilla(o.getCoorXi(), o.getCoorY()-1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()-1),d,movH,movV+1,i);
      
    }
    private boolean submoverH(Casilla o, Casilla d, int movH, int movV, int i){ //Mover incrementando primero la columna
           if (!inValido(o) || i==2)
               return false;
           else if (movH == 0 && movV ==0 && (o.esLibre() || o.esComible(this.getOpColor())))
               return true;
           else{
               if (!o.esLibre()) i++;
               if (movH<0)
                   return checkCasilla(o.getCoorXi()-1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()-1, o.getCoorY()),d,movH+1,movV,i);
               else if (movH>0)
                   return checkCasilla(o.getCoorXi()+1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()+1, o.getCoorY()),d,movH-1,movV,i);
               else if (movV<0)
                   return checkCasilla(o.getCoorXi(), o.getCoorY()-1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()-1),d,movH,movV+1,i);
               else //movV>0
                   return checkCasilla(o.getCoorXi(), o.getCoorY()+1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()+1),d,movH,movV-1,i);
           }
    }
    private boolean submoverV(Casilla o, Casilla d, int movH, int movV, int i){ //Mover incrementando primero la fila
        if (!inValido(o) || i==2)
               return false;
           else if (movH == 0 && movV ==0 && (o.esLibre() || o.esComible(this.getOpColor())))
               return true;
           else{
               if (!o.esLibre()) i++;
               if (movV<0)
                   return checkCasilla(o.getCoorXi(), o.getCoorY()-1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()-1),d,movH,movV+1,i);
               else if (movV>0)
                   return checkCasilla(o.getCoorXi(), o.getCoorY()+1) && submoverV(tab.getCasillaXY(o.getCoorXi(), o.getCoorY()+1),d,movH,movV-1,i);
               else if (movH<0)
                   return checkCasilla(o.getCoorXi()-1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()-1, o.getCoorY()),d,movH+1,movV,i);
               else //movH>0
                   return checkCasilla(o.getCoorXi()+1, o.getCoorY()) && submoverH(tab.getCasillaXY(o.getCoorXi()+1, o.getCoorY()),d,movH-1,movV,i);
           }
    }
    private boolean movValido(Casilla o, Casilla d){
        return (Math.abs(d.getCoorXi()-o.getCoorXi())==2 && Math.abs(d.getCoorY()-o.getCoorY())==1)
                ||(Math.abs(d.getCoorXi()-o.getCoorXi())==1 && Math.abs(d.getCoorY()-o.getCoorY())==2);
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
