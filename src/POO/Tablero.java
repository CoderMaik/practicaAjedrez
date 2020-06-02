package POO;

public class Tablero {
    private Casilla[][] mapa;
    //Constructor vacio
    public Tablero(){
        mapa = new Casilla[8][8];
    }
    public Tablero(String map){
        //constructor pasandole un tablero hecho
    }
    public Casilla getCasilla(char x, int y) {
        int n = getRowInt(x);
        return mapa[n][y];
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
}
