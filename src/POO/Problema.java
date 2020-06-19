package POO;

import Piezas.Caballo;
import Piezas.Color;
import Piezas.Pieza;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problema {

    private int resuelto_por;
    private double porcentaje_exito;
    private String jugada_ganadora;
    private Tablero tab;
    
    public Problema(File fichero) {
        this.resuelto_por = 0;
        this.porcentaje_exito = 0;
        fichero = new File("");
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            int charLeido = br.read();
            tab = new Tablero();
            int columna = 0;
            int fila = 8;
            while (charLeido != -1 || fila>=0) {
                char caracter = ((char) charLeido);
                if (fila != 0) {
                    switch (caracter) {
                        case 'V':
                            tab.getMapa()[fila][columna] = null; // no metemos pieza
                        case ',':
                            if (columna == 8) {
                                columna = 1;
                                fila--;
                            } else 
                                columna++;
                        case 'B':
                            tab.getMapa()[fila][columna].getContenido().setColor(Color.BLANCO);
                            break;
                        case 'N':
                            tab.getMapa()[fila][columna].getContenido().setColor(Color.NEGRO);
                            break;
                        case 'C':
                            Pieza caballo = new Caballo();
                            tab.getMapa()[fila][columna].addPieza(caballo);
                            caballo.setCas(tab.getMapa()[fila][columna]);
                            caballo.setTab(tab);
                            break;
                        case 'P':
                            Pieza peon = new Caballo();
                            tab.getMapa()[fila][columna].addPieza(peon);
                            peon.setCas(tab.getMapa()[fila][columna]);
                            peon.setTab(tab);
                            break;
                        case 'D':
                            Pieza dama = new Caballo();
                            tab.getMapa()[fila][columna].addPieza(dama);
                            dama.setCas(tab.getMapa()[fila][columna]);
                            dama.setTab(tab);
                            break;
                        case 'A':
                            Pieza alfil = new Caballo();
                            tab.getMapa()[fila][columna].addPieza(alfil);
                            alfil.setCas(tab.getMapa()[fila][columna]);
                            alfil.setTab(tab);
                            break;
                        case 'R':
                            Pieza rey = new Caballo();
                            tab.getMapa()[fila][columna].addPieza(rey);
                            rey.setCas(tab.getMapa()[fila][columna]);
                            rey.setTab(tab);
                            break;
                        case 'T':
                            Pieza torre = new Caballo();
                            tab.getMapa()[fila][columna].addPieza(torre);
                            torre.setCas(tab.getMapa()[fila][columna]);
                            torre.setTab(tab);
                            break;
                        default:
                            throw new IOException("Error al leer contenido");
                    }
                    charLeido = br.read();
                } else {
                    jugada_ganadora = br.readLine();
                    fila--; //ya termino, fila = -1
                }
            }
        } catch (IOException ioEx) {
            this.tab = null;
            this.jugada_ganadora = null;
            System.out.println(ioEx.getMessage());
        }
    }

    public int getResuelto_por() {
        return resuelto_por;
    }

    public void setResuelto_por(int resuelto_por) {
        this.resuelto_por = resuelto_por;
    }

    public double getPorcentaje_exito() {
        return porcentaje_exito;
    }

    public void setPorcentaje_exito(double porcentaje_exito) {
        this.porcentaje_exito = porcentaje_exito;
    }

    public String getJugada_ganadora() {
        return jugada_ganadora;
    }

    public void setJugada_ganadora(String jugada_ganadora) {
        this.jugada_ganadora = jugada_ganadora;
    }

    public String NumProblemAleatorio (){
        int NumProblem = (int) Math.floor( Math.random()*10+1);
        String sol = "";
        switch (NumProblem){
            case 1:
                jugada_ganadora = "Td8++";
                sol ="Solucion problema 1 = "+jugada_ganadora;
                break;
            case 2:
                jugada_ganadora = "Cg6++";
                sol ="Solucion problema 2 = "+jugada_ganadora;
                break;
            case 3:
                jugada_ganadora = "fxg8=C++";
                sol ="Solucion problema 3 = "+jugada_ganadora;
                break;
            case 4:
                jugada_ganadora = "f8=D++";
                sol ="Solucion problema 4 = "+jugada_ganadora;
                break;
            case 5:
                jugada_ganadora = "dxe8=C++";
                sol ="Solucion problema 5 = "+jugada_ganadora;
                break;
            case 6:
                jugada_ganadora= "Dc6++";
                sol ="Solucion problema 6 = "+jugada_ganadora;
                break;
            case 7:
                jugada_ganadora = "Cd7++ ";
                sol ="Solucion problema 7 = "+jugada_ganadora;
                break;
            case 8:
                jugada_ganadora = "Cxe6++";
                sol ="Solucion problema 8 = "+jugada_ganadora;
                break;
            case 9:
                jugada_ganadora = "h7++";
                sol ="Solucion problema 9 = "+jugada_ganadora;
                break;
            case 10:
                jugada_ganadora = "TxC7++";
                sol ="Solucion problema 10 = "+jugada_ganadora;
                break;
        }
        return sol;
    }

}
