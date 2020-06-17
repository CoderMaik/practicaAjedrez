package POO;

import Piezas.Caballo;
import Piezas.Pieza;
import Piezas.Rey;
import POO.Casilla;
import Piezas.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tablero {
    private Casilla[][] mapa;
    //Constructor vacio
    public Tablero (){
        mapa = new Casilla[8][8];
    }

    public Tablero(File fichero) throws IOException {
        fichero = new File("");
        try (FileReader fileReader = new FileReader(fichero)) {
            int charLeido = fileReader.read(); // lo que lee el fichero es el caracter o -1 si hemos llegado al final
            int columna = 0;
            int fila = 8;
            int index = 0;
            while (charLeido != -1) {
                char caracter = ((char) charLeido);
                // switch
                if (caracter == 'V') {
                    mapa[fila][columna] = null; // no metemos pieza
                }else if (caracter == ','){
                    if (columna == 8){
                        columna = 1;
                        fila --;
                    }else{
                        columna ++;
                    }
                }else if(caracter == 'B'){
                    mapa[fila][columna].getContenido().setColor(Color.BLANCO);
                }else if(caracter =='N'){
                    mapa[fila][columna].getContenido().setColor(Color.NEGRO);
                }else{
                    switch (caracter){
                        case 'C':
                            Pieza caballo = new Caballo();
                            mapa[fila][columna].addPieza(caballo);
                            caballo.setCas(mapa[fila][columna]);
                            caballo.setTab(this);
                        case 'P':
                            Pieza peon= new Caballo();
                            mapa[fila][columna].addPieza(peon);
                            peon.setCas(mapa[fila][columna]);
                            peon.setTab(this);
                        case 'D':
                            Pieza dama = new Caballo();
                            mapa[fila][columna].addPieza(dama);
                            dama.setCas(mapa[fila][columna]);
                            dama.setTab(this);
                        case 'A':
                            Pieza alfil = new Caballo();
                            mapa[fila][columna].addPieza(alfil);
                            alfil.setCas(mapa[fila][columna]);
                            alfil.setTab(this);
                        case 'R':
                            Pieza rey = new Caballo();
                            mapa[fila][columna].addPieza(rey);
                            rey.setCas(mapa[fila][columna]);
                            rey.setTab(this);
                        case 'T':
                            Pieza torre = new Caballo();
                            mapa[fila][columna].addPieza(torre);
                            torre.setCas(mapa[fila][columna]);
                            torre.setTab(this);
                    }
                }
                charLeido = fileReader.read(); // equivalente a i++
            }
        } catch (IOException ioEx) {
            // poner mensaje caso excepcion o devolver false
        }
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
