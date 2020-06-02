package Piezas;

public class Alfil extends Pieza {
    private final char simbolo = 'A';
    private char letra = simbolo;

    public Alfil(Color color) {
        super('A', color);
    }

    public boolean mover() {
        throw new RuntimeException("Not implemented yet");
    }
}
