package Piezas;

public class Caballo extends Pieza {
    private final char simbolo = 'C';
    private char letra = simbolo;

    public Caballo(Color color) {
        super('C', color);
    }

    public boolean mover() {
        throw new RuntimeException("Not implemented yet");
    }
}
