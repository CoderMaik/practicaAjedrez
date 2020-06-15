package Piezas;

public abstract class Pieza {
    private char letra;
    private Color color;

    public Pieza(char letra, Color color) {
        this.letra = letra;
        this.color = color;
    }

    public abstract boolean mover();

    private boolean movValido(String mov) {
        return mov.matches("[a-h][1-8]");
    }

    //public boolean estaAmenazada(){}
}
