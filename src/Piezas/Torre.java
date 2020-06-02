package Piezas;

public class Torre extends Pieza {
    private final char simbolo = 'T';
    private char letra = simbolo;

    public Torre(Color color) {
        super('T', color);
    }

    public boolean mover() {
        throw new RuntimeException("Not implemented yet");
    }
}
