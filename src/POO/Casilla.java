package POO;

import static POO.Tablero.getRowInt;
import Piezas.Color;
import Piezas.Pieza;

public class Casilla {
    private char coorX;
    private int coorY;
    private boolean libre;
    private Pieza contenido;
    
    public Casilla() {
        libre=true;
    }

    public Casilla(char x, int y) {
        coorX = x;
        coorY = y;
        libre=true;
    }

    public void addPieza(Pieza p) {
        libre = false;
        this.contenido = p;
        p.setCas(this);
    }

    public void removePieza() {
        if(this.contenido!=null)
            this.contenido.setCas(null);
        this.contenido = null; //Creo que es opcional
        libre = true;
    }
    //DE LA PARTE OPCIONAL
    public int amenazadaPor(Tablero tab, Color color){ //Devuelve el numero de piezas amenazando la casilla
        Pieza s = null;
        if(this.getContenido()!=null){
            s = this.getContenido();
            this.removePieza();
        }
        int cont=0;
        for(int fil=7;fil>=0;fil--){
            for(int col=0;col<8;col++){
                Pieza p = tab.getMapa()[fil][col].getContenido();
                if(p!=null && p.getColor().equals(color) && p.mover(tab.getCasillaXY(col,fil),this)){
                    cont++;                
                }else if(p!=null && p.getColor().equals(color) && (p.getLetra()=='P' || p.getLetra()=='p')){
                    Pieza ghost = Pieza.nuevaPieza('p'); //SIMULAR PIEZA NEGRA PARA PODER MOVER EN DIAGONAL
                    ghost.setColor(Color.NEGRO);  
                    this.addPieza(ghost);
                    if(p.mover(tab.getCasillaXY(col,fil),this))
                        cont++;
                    this.removePieza();
                }
            }
        }if(s!=null)this.addPieza(s);
        return cont;
    }

    public Pieza getContenido() {return this.contenido;}
    public int getCoorXi(){return getRowInt(coorX);}
    public char getCoorX() {return coorX;}
    public int getCoorY() {return coorY;}
    public boolean esLibre() {return libre;}
    public boolean esComible(Color color) {
        return (color == contenido.getColor());
    }
}
