package Piezas;

import POO.Casilla;
import POO.Tablero;

public class Rey extends Pieza {
    private final char simbolo = 'R';

    public Rey() {}

    @Override
    public boolean mover(Casilla origen, Casilla destino) {
        return !(!inValido(destino) || !origenValido(origen) || !movValido(origen,destino) || (!destino.esLibre() && !destino.esComible(this.getOpColor())));
    }
    private boolean movValido(Casilla origen, Casilla destino){
        return(!origen.equals(destino) &&
                Math.abs(destino.getCoorX()-origen.getCoorX())<=1 &&
                    Math.abs(destino.getCoorY()-origen.getCoorY())<=1);
    }
    
    @Override
    public char getLetra (){return this.simbolo;}
    
    //DE LA PARTE OPCIONAL
    
    @Override
    public boolean reyEscapatoria(){
        int x = Tablero.getRowInt(this.cas.getCoorX());
        int y = cas.getCoorY();
        return (Tablero.checkCasilla(x,y) && this.tab.getCasillaXY(x,y).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x+1,y) && this.tab.getCasillaXY(x+1,y).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x-1,y) && this.tab.getCasillaXY(x-1,y).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x,y+1) && this.tab.getCasillaXY(x,y+1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x,y-1) && this.tab.getCasillaXY(x,y-1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x+1,y+1) && this.tab.getCasillaXY(x+1,y+1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x+1,y-1) && this.tab.getCasillaXY(x+1,y-1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x-1,y+1) && this.tab.getCasillaXY(x-1,y+1).amenazadaPor(tab,this.getOpColor())==0)
                || (Tablero.checkCasilla(x-1,y-1) && this.tab.getCasillaXY(x-1,y-1).amenazadaPor(tab,this.getOpColor())==0);
    }
    
    @Override
    public boolean mitigarUnaAmenaza(){ //No se contempla que pueda comerme la amenaza con varias piezas y solo una opción sirva. Coge la primera siempre :(
        int x=Tablero.getRowInt(this.cas.getCoorX());
        int y = cas.getCoorY();
        //Para la vuelta atrás
        Pieza p; Pieza p2;
        Casilla original; 
        //Cada If es una casilla adyacente al Rey negro, compruebo si la amenaza es única (si no, no hay posibilidad de escape)
        //Podríamos haber hecho un mismo método para el cuerpo de los IF pero demasiados parámetros, preferimos dejarlo así
        if(Tablero.checkCasilla(x,y) && this.tab.getCasillaXY(x,y).amenazadaPor(tab,this.getOpColor())==1){
           p = this.tab.findAmenaza(this.tab.getCasillaXY(x,y),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }if(Tablero.checkCasilla(x+1,y) && this.tab.getCasillaXY(x+1,y).amenazadaPor(tab,this.getOpColor())==1){
           p = this.tab.findAmenaza(this.tab.getCasillaXY(x+1,y),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           } 
        }if(Tablero.checkCasilla(x-1,y) && this.tab.getCasillaXY(x-1,y).amenazadaPor(tab,this.getOpColor())==1){
            p = this.tab.findAmenaza(this.tab.getCasillaXY(x-1,y),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }if(Tablero.checkCasilla(x,y+1) && this.tab.getCasillaXY(x,y+1).amenazadaPor(tab,this.getOpColor())==1){
            p = this.tab.findAmenaza(this.tab.getCasillaXY(x,y+1),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }if(Tablero.checkCasilla(x,y-1) && this.tab.getCasillaXY(x,y-1).amenazadaPor(tab,this.getOpColor())==1){
            p = this.tab.findAmenaza(this.tab.getCasillaXY(x,y-1),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }if(Tablero.checkCasilla(x+1,y+1) && this.tab.getCasillaXY(x+1,y+1).amenazadaPor(tab,this.getOpColor())==1){
            p = this.tab.findAmenaza(this.tab.getCasillaXY(x+1,y+1),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }if(Tablero.checkCasilla(x+1,y-1) && this.tab.getCasillaXY(x+1,y-1).amenazadaPor(tab,this.getOpColor())==1){
            p = this.tab.findAmenaza(this.tab.getCasillaXY(x+1,y-1),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }if(Tablero.checkCasilla(x-1,y+1) && this.tab.getCasillaXY(x-1,y+1).amenazadaPor(tab,this.getOpColor())==1){
            p = this.tab.findAmenaza(this.tab.getCasillaXY(x-1,y+1),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }if(Tablero.checkCasilla(x-1,y-1) && this.tab.getCasillaXY(x-1,y-1).amenazadaPor(tab,this.getOpColor())==1){
            p = this.tab.findAmenaza(this.tab.getCasillaXY(x-1,y-1),this.getOpColor());
           if(p.getCas().amenazadaPor(tab,color)>0){ //Si me puedo comer a la pieza blanca que me amenaza:
                p2 = this.tab.findAmenaza(p.getCas(), color);
                original = p2.getCas();
                p2.getCas().removePieza();
                p.getCas().addPieza(p2);
                if(this.reyEscapatoria())//Me la como y miro si tengo escapatoria y ha fallado el jaque mate
                    return true;
                else{
                    original.addPieza(p2);
                    p.getCas().addPieza(p);
                }
           }
        }return false;
    }
    
}
