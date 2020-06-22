package POO;

import Piezas.Color;
import Piezas.Pieza;

public class Tablero {

    private Casilla[][] mapa;

    //Constructor vacio
    public Tablero() {
        mapa = new Casilla[8][8];
    }

    public Casilla getCasilla(char x, int y) {
        int n = getRowInt(x);
        return mapa[n][y];
    }

    public Casilla getCasillaXY(int x, int y) {
        return mapa[x][y];
    }

    public Casilla[][] getMapa() {
        return mapa;
    }

    public static int getRowInt(char x) {
        switch (x) {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'd':
                return 4;
            case 'e':
                return 5;
            case 'f':
                return 6;
            case 'g':
                return 7;
            case 'h':
                return 8;
            default:
                return 0;
        }
    }

    public static char getRowChar(int x) {
        switch (x) {
            case 1:
                return 'a';
            case 2:
                return 'b';
            case 3:
                return 'c';
            case 4:
                return 'd';
            case 5:
                return 'e';
            case 6:
                return 'f';
            case 7:
                return 'g';
            case 8:
                return 'h';
            default:
                return 'x';
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
            for (int columna = 0; columna<8; columna++){
                if (mapa[fila][columna].getContenido() == null){
                    tab += "V ,";
                }else {
                    tab += mapa[fila][columna].getContenido().getLetra();
                    if (mapa[fila][columna].getContenido().getColor() == Color.BLANCO){
                        tab += "B ,";
                    }else{
                        tab += "N ,";
                    }
                }
            }
            tab += "/n";
        }
        return tab;
    }

}
