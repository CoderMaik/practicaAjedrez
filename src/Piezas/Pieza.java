package Piezas;

import POO.Casilla;
import POO.Tablero;

public abstract class Pieza {
    protected Color color;
    protected Tablero tab;
    protected Casilla cas;

    protected Pieza() {}

    public Pieza nuevaPieza(char c) {
        switch (c) {
            case 'T' | 't':
                return new Torre();
            case 'C' | 'c':
                return new Caballo();
            case 'P' | 'p':
                return new Peon();
            case 'D' | 'd':
                return new Dama();
            case 'R' | 'r':
                return new Rey();
            case 'A' | 'a':
                return new Alfil();
            default:
                throw new RuntimeException("Error al crear la pieza");
        }
    }

    public abstract boolean mover(Casilla origen, Casilla destino);

    /*protected boolean movValido(String mov) { USELESS??
        return mov.matches("[a-h][1-8]");
    }*/

    protected boolean origenValido(Casilla origen) {
        return (origen.equals(cas) && inValido(origen));
    }

    protected boolean inValido(Casilla origen) {
        return (Tablero.getRowInt(origen.getCoorX()) > 0 && Tablero.getRowInt(origen.getCoorX()) < 8 && origen.getCoorY() < 8 && origen.getCoorY() > 0);
    }

    //Getters and setters
    public Color getColor() {return color;}

    public Color getOpColor(){ //Devuelve el color opuesto
        if (this.color == Color.BLANCO)
            return Color.NEGRO;
        else
            return Color.BLANCO;
    }
    public void setColor(Color color) {this.color = color;}

    public Tablero getTab() {return tab;}

    public void setTab(Tablero tab) {this.tab = tab;}

    public Casilla getCas() {return cas;}

    public void setCas(Casilla cas) {this.cas = cas;}
    public abstract char getLetra ();
}
