package Piezas;

public class Rey extends Pieza {
    private final char simbolo = 'R';
    private char letra = simbolo;

    public Rey(Color color) {
        super('R', color);
    }

    public boolean mover() {
        throw new RuntimeException("Not implemented yet");
    }
}
