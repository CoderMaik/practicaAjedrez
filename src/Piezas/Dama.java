package Piezas;

public class Dama extends Pieza {
    private final char simbolo = 'D';
    private char letra = simbolo;

    public Dama(Color color) {
        super('D', color);
    }

    public boolean mover() {
        throw new RuntimeException("Not implemented yet");
    }
}
