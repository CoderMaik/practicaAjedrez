package Piezas;

public class Peon extends Pieza {
    private final char simbolo = 'P';
    private char letra = simbolo;

    public Peon(Color color) {
        super('P', color);
    }

    public boolean mover() {
        throw new RuntimeException("Not implemented yet");
    }
}
