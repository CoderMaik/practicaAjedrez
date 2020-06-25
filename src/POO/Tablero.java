package POO;

import Piezas.Color;
import Piezas.Pieza;

public class Tablero {

    private Casilla[][] mapa;

    //Constructor vacio
    public Tablero() {
        mapa = new Casilla[8][8];
        for (int fil = 0; fil < 8; fil++) {
            for (int col = 7; col >= 0; col--) {
                mapa[fil][col]= new Casilla();
            }    
        }
    }

    public Casilla getCasilla(char x, int fil) {
        int n = getRowInt(x);
        return mapa[fil][n];
    }

    public Casilla getCasillaXY(int fil, int col) {
        return mapa[fil][col];
    }
    public static boolean checkCasilla(int x, int y){
        return  x<8 && x>=0 && y<8 && y>=0;
    }
    public Casilla[][] getMapa() {
        return mapa;
    }

    public static int getRowInt(char x) {
        switch (x) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                return -1;
        }
    }

    public Pieza moveR(char pieza,Casilla destino){ //CASO GENERICO
        Pieza p;
        for (int fil=7;fil>=0;fil--){
            for(int col=0;col<8;col++){
                p = this.mapa[fil][col].getContenido();
                if(p.getLetra()==pieza && p.getColor().equals(Color.BLANCO)&& p.mover(this.getCasillaXY(fil,col),destino))
                    return p;
            }
        }return null;
    }
    public Pieza moveR(char pieza,Casilla destino,char colOrigen){ //MOVER PEON COMIENDO O PIEZA CON VARIAS POSIBILIDADES
        int colInt = Character.getNumericValue(colOrigen);
        Pieza p;
        for (int fil=7;fil>=0;fil--){
            p = this.mapa[fil][colInt].getContenido();
            if(p.getLetra()==pieza && p.getColor().equals(Color.BLANCO) && p.mover(this.getCasillaXY(fil,colInt),destino))
                return p;
        }return null;
    }
    @Override
    public String toString(){
        String tab ="";
        for (int fila = 7; fila>=0; fila--){
            tab+=fila+1+"  ";
            for (int columna = 0; columna<8; columna++){
                if (mapa[fila][columna].esLibre()){
                    tab += "| V  ";
                }else {
                    tab += "|"+mapa[fila][columna].getContenido().getLetra();
                    if (mapa[fila][columna].getContenido().getColor() == Color.BLANCO){
                        tab += "B";
                    }else{
                        tab += "N";
                    }
                }
            }
            tab += "|\n";
        }tab+="       a    b    c    d    e    f    g    h";
        return tab;
    }
}
