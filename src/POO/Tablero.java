package POO;

import Piezas.Rey;
import POO.Casilla;
import Piezas.Color;

public class Tablero {
    private Casilla[][] mapa;
    //Constructor vacio
    public Tablero (){
        mapa = new Casilla[8][8];
    }
    public Tablero(String map){
        int columna = 0;
        int fila = 8;
        int index = 0;
        while (!map.equals(null)){
            if (map.charAt(index) == 'V') {
                mapa[fila][columna].checkPieza(mapa[fila][columna]).setCas() = null;
            }else if (map.charAt(index) == ','){
                if (columna == 8){
                    columna = 1;
                    fila --;
                }else{
                    columna ++;
                }
            }else if ((map.charAt(index) == 'B') || (map.charAt(index) == 'N')){
                if (map.charAt(index) == 'B'){
                    mapa[fila][columna].checkPieza(mapa[fila][columna]).setColor('BLANCO');
                }else {
                    mapa[fila][columna].checkPieza(mapa[fila][columna]).setColor('NEGRO');
                }
            }else {
                mapa[fila][columna].checkPieza(mapa[fila][columna]).setTab();
                mapa[fila][columna].checkPieza(mapa[fila][columna]).setCas();
            }
            index ++;
        }
        //constructor pasandole un tablero hecho
    }
    public Casilla getCasilla(char x, int y) {
        int n = getRowInt(x);
        return mapa[n][y];
    }
    public Casilla getCasillaXY(int x, int y){
        return mapa[x][y];
    }
    public Casilla[][] getMapa(){return mapa;}
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
}
