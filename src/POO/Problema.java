package src.POO;

import java.util.Random;

public class Problema {

    private int resuelto_por;
    private double porcentaje_exito;
    private String jugada_ganadora;
    private boolean valido;

    public Problema(String jugGan, Boolean Valid) {
        this.resuelto_por = 0;
        this.porcentaje_exito = 0;
        this.jugada_ganadora = jugGan;
        this.valido = Valid;
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

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String NumProblemAleatorio (){
        int NumProblem = (int) Math.floor( Math.random()*10+1);
        //Es 10 + 1 porque asi lee el 10, sino solo leeria hasta el 9
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
    public boolean EsVaalido(String jugada) {
        boolean sol = false;
        if (jugada == jugada_ganadora) {
            sol = true;
        }
        return sol;
    }
}
