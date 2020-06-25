package POO;

import Piezas.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class AlmacenProblemas implements Serializable {
    private ArrayList<Problema> listaProblemas;

    public AlmacenProblemas() {
        this.listaProblemas = new ArrayList<>();
    }

    public boolean existeProblema(Problema p) {
        boolean found = false;
        Iterator<Problema> it = listaProblemas.iterator();
        Problema aux;
        while ((!found) && it.hasNext()) {
            aux = it.next();
            found = aux.equals(p);
        }
        return found;
    }

    public ArrayList<Problema> getListaProblemas() {
        return listaProblemas;
    }

    public boolean addProblema(Problema p) {
        if (!existeProblema(p))
            return this.listaProblemas.add(p);
        else
            return false;
    }

    public boolean borrarProblema(Problema p) {
        if (!existeProblema(p))
            return listaProblemas.remove(p);
        else
            return false;
    }

    public boolean validarProblema(Problema problem) {
        return !existeProblema(problem) && EsValido(problem);
    }

    private boolean EsValido(Problema problem) {
        throw new RuntimeException("not implemented yet");
    }
    
    public Problema problemAleatorio (Usuario u) {
            Random rand = new Random();
            Problema p = listaProblemas.get(rand.nextInt(listaProblemas.size()));
            return p;
    }
    public int getIndexOf(Problema p){
        for (int i = 0; i < listaProblemas.size(); i++) {
            if(listaProblemas.get(i).equals(p))
                return i+1;           
        }return -1;
    }
        /*Lo dejo comentado para saber las soluciones a los problemas pero no sirve
            case 1:
                jugada_ganadora = "Td8++";
            case 2:
                jugada_ganadora = "Cg6++";
            case 3:
                jugada_ganadora = "fxg8=C++";
            case 4:
                jugada_ganadora = "f8=D++";
            case 5:
                jugada_ganadora = "dxe8=C++";
            case 6:
                jugada_ganadora= "Dc6++";
            case 7:
                jugada_ganadora = "Cd7++ ";
            case 8:
                jugada_ganadora = "Cxe6++";
            case 9:
                jugada_ganadora = "h7++";
            case 10:
                jugada_ganadora = "TxC7++";*/

    public void escribeAlmacenProblemas(String n) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(n);
        ObjectOutputStream salida = new ObjectOutputStream(fileOut);
        salida.writeObject(this.listaProblemas);
        salida.close();
    }

    public boolean leerAlmacenProblemas(String nameFile) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fichero = new FileInputStream(nameFile);
            ObjectInputStream input = new ObjectInputStream(fichero);
            this.listaProblemas = (ArrayList<Problema>) input.readObject();
            input.close();
            return true;
        } catch (ClassNotFoundException | IOException noEncontrado) {
            return false;
        }
    }

    public void problemasBase() {

         //PROBLEMA 1

                Tablero tablero_1 = new Tablero();
                Pieza pieza = new Rey();
                Casilla casilla_1 = new Casilla('g', 7);
                pieza.setColor(Color.NEGRO);
                pieza.setTab(tablero_1);
                casilla_1.addPieza(pieza);
                tablero_1.getMapa()[7][6] = casilla_1;

                Pieza p_2 = new Peon();
                Casilla c_2 = new Casilla('a', 6);
                p_2.setCas(c_2);
                p_2.setColor(Color.NEGRO);
                p_2.setTab(tablero_1);
                c_2.addPieza(p_2);
                tablero_1.getMapa()[6][0] = c_2;

                Pieza p_3 = new Peon();
                Casilla c_3 = new Casilla('c', 6);
                p_3.setCas(c_3);
                p_3.setColor(Color.NEGRO);
                p_3.setTab(tablero_1);
                c_3.addPieza(p_3);
                tablero_1.getMapa()[6][2] = c_3;

                Pieza p_4 = new Torre();
                Casilla c_4 = new Casilla('f',6);
                p_4.setCas(c_4);
                p_4.setColor(Color.NEGRO);
                p_4.setTab(tablero_1);
                c_4.addPieza(p_4);
                tablero_1.getMapa()[6][5] = c_4;

                Pieza p_5 = new Peon();
                Casilla c_5 = new Casilla('g', 6);
                p_5.setCas(c_5);
                p_5.setColor(Color.NEGRO);
                p_5.setTab(tablero_1);
                c_5.addPieza(p_5);
                tablero_1.getMapa()[6][6] = c_5;

                Pieza p_6 = new Peon();
                Casilla c_6 = new Casilla('h', 6);
                p_6.setCas(c_6);
                p_6.setColor(Color.NEGRO);
                p_6.setTab(tablero_1);
                c_6.addPieza(p_6);
                tablero_1.getMapa()[6][7] = c_6;

                Pieza p_7 = new Dama();
                Casilla c_7 = new Casilla('b', 5);
                p_7.setCas(c_7);
                p_7.setColor(Color.NEGRO);
                p_7.setTab(tablero_1);
                c_7.addPieza(p_7);
                tablero_1.getMapa()[5][1] = c_7;

                Pieza p_8 = new Peon();
                Casilla c_8 = new Casilla('c', 4);
                p_8.setCas(c_8);
                p_8.setColor(Color.NEGRO);
                p_8.setTab(tablero_1);
                c_8.addPieza(p_8);
                tablero_1.getMapa()[4][2] = c_8;

                Pieza p_9 = new Peon();
                Casilla c_9 = new Casilla('e', 3);
                p_9.setCas(c_9);
                p_9.setColor(Color.BLANCO);
                p_9.setTab(tablero_1);
                c_9.addPieza(p_9);
                tablero_1.getMapa()[3][4] = c_9;

                Pieza p_10 = new Peon();
                Casilla c_10 = new Casilla('a', 2);
                p_10.setCas(c_10);
                p_10.setColor(Color.BLANCO);
                p_10.setTab(tablero_1);
                c_10.addPieza(p_10);
                tablero_1.getMapa()[2][0] = c_10;

                Pieza p_11 = new Dama();
                Casilla c_11 = new Casilla('b', 2);
                p_11.setCas(c_11);
                p_11.setColor(Color.BLANCO);
                p_11.setTab(tablero_1);
                c_11.addPieza(p_11);
                tablero_1.getMapa()[2][1] = c_11;

                Pieza p_12 = new Peon();
                Casilla c_12 = new Casilla('b', 1);
                p_12.setCas(c_12);
                p_12.setColor(Color.BLANCO);
                p_12.setTab(tablero_1);
                c_12.addPieza(p_12);
                tablero_1.getMapa()[1][1] = c_12;

                Pieza p_13 = new Peon();
                Casilla c_13 = new Casilla('g', 1);
                p_13.setCas(c_13);
                p_13.setColor(Color.BLANCO);
                p_13.setTab(tablero_1);
                c_13.addPieza(p_13);
                tablero_1.getMapa()[1][6] = c_13;

                Pieza p_14 = new Peon();
                Casilla c_14 = new Casilla('h', 1);
                p_14.setCas(c_14);
                p_14.setColor(Color.BLANCO);
                p_14.setTab(tablero_1);
                c_14.addPieza(p_14);
                tablero_1.getMapa()[1][7] = c_14;

                Pieza p_15 = new Torre();
                Casilla c_15 = new Casilla('d', 0);
                p_15.setCas(c_15);
                p_15.setColor(Color.BLANCO);
                p_15.setTab(tablero_1);
                c_15.addPieza(p_15);
                tablero_1.getMapa()[0][3] = c_15;

                Pieza p_16 = new Rey();
                Casilla c_16 = new Casilla('h', 0);
                p_16.setCas(c_16);
                p_16.setColor(Color.BLANCO);
                p_16.setTab(tablero_1);
                c_16.addPieza(p_16);
                tablero_1.getMapa()[0][7] = c_16;

                Problema p = new Problema();
                p.setTab(tablero_1);
                addProblema(p);
                p.setJugada_ganadora("Td8++");

//PROBLEMA 2
                Tablero tablero_2 = new Tablero();
                Pieza pi_1 = new Torre();
                Casilla ca_1 = new Casilla('a', 7);
                pi_1.setCas(ca_1);
                pi_1.setColor(Color.NEGRO);
                pi_1.setTab(tablero_2);
                ca_1.addPieza(pi_1);
                tablero_2.getMapa()[7][0] = ca_1;

                Pieza pi_2 = new Caballo();
                Casilla ca_2 = new Casilla('b', 7);
                pi_2.setCas(ca_2);
                pi_2.setColor(Color.NEGRO);
                pi_2.setTab(tablero_2);
                ca_2.addPieza(pi_2);
                tablero_2.getMapa()[7][1] = ca_2;

                Pieza pi_3 = new Alfil();
                Casilla ca_3 = new Casilla('c', 7);
                pi_3.setCas(ca_3);
                pi_3.setColor(Color.NEGRO);
                pi_3.setTab(tablero_2);
                ca_3.addPieza(pi_3);
                tablero_2.getMapa()[7][2] = ca_3;

                Pieza pi_4 = new Rey();
                Casilla ca_4 = new Casilla('h', 7);
                pi_4.setCas(ca_4);
                pi_4.setColor(Color.NEGRO);
                pi_4.setTab(tablero_2);
                ca_4.addPieza(pi_4);
                tablero_2.getMapa()[7][7] = ca_4;

                Pieza pi_5 = new Peon();
                Casilla ca_5 = new Casilla('a', 6);
                pi_5.setCas(ca_5);
                pi_5.setColor(Color.NEGRO);
                pi_5.setTab(tablero_2);
                ca_5.addPieza(pi_5);
                tablero_2.getMapa()[6][0] = ca_5;

                Pieza pi_14 = new Peon();
                Casilla ca_14 = new Casilla('g', 6);
                pi_14.setCas(ca_14);
                pi_14.setColor(Color.NEGRO);
                pi_14.setTab(tablero_2);
                ca_14.addPieza(pi_14);
                tablero_2.getMapa()[6][6] = ca_14;

                Pieza pi_6 = new Peon();
                Casilla ca_6 = new Casilla('h', 6);
                pi_6.setCas(ca_6);
                pi_6.setColor(Color.NEGRO);
                pi_6.setTab(tablero_2);
                ca_6.addPieza(pi_6);
                tablero_2.getMapa()[6][7] = ca_6;

                Pieza pi_7 = new Caballo();
                Casilla ca_7 = new Casilla('e', 4);
                pi_7.setCas(ca_7);
                pi_7.setColor(Color.BLANCO);
                pi_7.setTab(tablero_2);
                ca_7.addPieza(pi_7);
                tablero_2.getMapa()[4][4] = ca_7;

                Pieza pi_8 = new Alfil();
                Casilla ca_8 = new Casilla('b', 2);
                pi_8.setCas(ca_8);
                pi_8.setColor(Color.BLANCO);
                pi_8.setTab(tablero_2);
                ca_8.addPieza(pi_8);
                tablero_2.getMapa()[2][1] = ca_8;

                Pieza pi_9 = new Peon();
                Casilla ca_9 = new Casilla('a', 1);
                pi_9.setCas(ca_9);
                pi_9.setColor(Color.BLANCO);
                pi_9.setTab(tablero_2);
                ca_9.addPieza(pi_9);
                tablero_2.getMapa()[1][0] = ca_9;

                Pieza pi_10 = new Peon();
                Casilla ca_10 = new Casilla('b', 1);
                pi_10.setCas(ca_10);
                pi_10.setColor(Color.BLANCO);
                pi_10.setTab(tablero_2);
                ca_10.addPieza(pi_10);
                tablero_2.getMapa()[1][1] = ca_10;

                Pieza pi_11 = new Peon();
                Casilla ca_11 = new Casilla('c', 1);
                pi_11.setCas(ca_11);
                pi_11.setColor(Color.BLANCO);
                pi_11.setTab(tablero_2);
                ca_11.addPieza(pi_11);
                tablero_2.getMapa()[1][2] = ca_11;

                Pieza pi_12 = new Rey();
                Casilla ca_12 = new Casilla('c', 0);
                pi_12.setCas(ca_12);
                pi_12.setColor(Color.BLANCO);
                pi_12.setTab(tablero_2);
                ca_12.addPieza(pi_12);
                tablero_2.getMapa()[0][2] = ca_12;

                Pieza pi_13 = new Torre();
                Casilla ca_13 = new Casilla('h', 0);
                pi_13.setCas(ca_13);
                pi_13.setColor(Color.BLANCO);
                pi_13.setTab(tablero_2);
                ca_13.addPieza(pi_13);
                tablero_2.getMapa()[0][7] = ca_13;

                Problema po = new Problema();
                po.setTab(tablero_2);
                addProblema(po);
                po.setJugada_ganadora("Cg6++");

 //PROBLEMA 3
                Tablero tablero_3 = new Tablero();

                Pieza pie_1 = new Torre();
                Casilla cas_1 = new Casilla('g', 7);
                pie_1.setCas(cas_1);
                pie_1.setColor(Color.NEGRO);
                pie_1.setTab(tablero_3);
                cas_1.addPieza(pie_1);
                tablero_3.getMapa()[7][6] = cas_1;

                Pieza pie_2 = new Dama();
                Casilla cas_2 = new Casilla('c', 6);
                pie_2.setCas(cas_2);
                pie_2.setColor(Color.BLANCO);
                pie_2.setTab(tablero_3);
                cas_2.addPieza(pie_2);
                tablero_3.getMapa()[6][2] = cas_2;

                Pieza pie_3 = new Peon();
                Casilla cas_3 = new Casilla('f', 6);
                pie_3.setCas(cas_3);
                pie_3.setColor(Color.BLANCO);
                pie_3.setTab(tablero_3);
                cas_3.addPieza(pie_3);
                tablero_3.getMapa()[6][5] = cas_3;

                Pieza pie_4 = new Rey();
                Casilla cas_4 = new Casilla('f', 5);
                pie_4.setCas(cas_4);
                pie_4.setColor(Color.NEGRO);
                pie_4.setTab(tablero_3);
                cas_4.addPieza(pie_4);
                tablero_3.getMapa()[5][5] = cas_4;

                Pieza pie_5 = new Peon();
                Casilla cas_5 = new Casilla('f', 4);
                pie_5.setCas(cas_5);
                pie_5.setColor(Color.BLANCO);
                pie_5.setTab(tablero_3);
                cas_5.addPieza(pie_5);
                tablero_3.getMapa()[4][5] = cas_5;

                Pieza pie_6 = new Rey();
                Casilla cas_6 = new Casilla('f', 3);
                pie_6.setCas(cas_6);
                pie_6.setColor(Color.BLANCO);
                pie_6.setTab(tablero_3);
                cas_6.addPieza(pie_6);
                tablero_3.getMapa()[3][5] = cas_6;

                Problema pob = new Problema();
                pob.setTab(tablero_3);
                addProblema(pob);
                pob.setJugada_ganadora("fxg8=C++");
//PROBLEMA 4
                Tablero tablero_4 = new Tablero();
                    Pieza piez_1 = new Peon();
                    Casilla casi_1 = new Casilla('d', 6);
                    piez_1.setCas(casi_1);
                    piez_1.setColor(Color.NEGRO);
                    piez_1.setTab(tablero_4);
                    casi_1.addPieza(piez_1);
                    tablero_4.getMapa()[6][3] = casi_1;


                    Pieza piez_2 = new Rey();
                    Casilla casi_2 = new Casilla('e', 6);
                    piez_2.setCas(casi_2);
                    piez_2.setColor(Color.NEGRO);
                    piez_2.setTab(tablero_4);
                    casi_2.addPieza(piez_2);
                    tablero_4.getMapa()[6][4] = casi_2;

                    Pieza piez_3 = new Peon();
                    Casilla casi_3 = new Casilla('f', 6);
                    piez_3.setCas(casi_3);
                    piez_3.setColor(Color.BLANCO);
                    piez_3.setTab(tablero_4);
                    casi_3.addPieza(piez_3);
                    tablero_4.getMapa()[6][5] = casi_3;

                    Pieza piez_4 = new Peon();
                    Casilla casi_4 = new Casilla('e', 5);
                    piez_4.setCas(casi_4);
                    piez_4.setColor(Color.NEGRO);
                    piez_4.setTab(tablero_4);
                    casi_4.addPieza(piez_4);
                    tablero_4.getMapa()[5][4] = casi_4;

                    Pieza piez_5 = new Rey();
                    Casilla casi_5 = new Casilla('d', 2);
                    piez_5.setCas(casi_5);
                    piez_5.setColor(Color.BLANCO);
                    piez_5.setTab(tablero_4);
                    casi_5.addPieza(piez_5);
                    tablero_4.getMapa()[2][3] = casi_5;

                    Pieza piez_6 = new Torre();
                    Casilla casi_6 = new Casilla('f', 0);
                    piez_6.setCas(casi_6);
                    piez_6.setColor(Color.BLANCO);
                    piez_6.setTab(tablero_4);
                    casi_6.addPieza(piez_6);
                    tablero_4.getMapa()[0][5] = casi_6;

                    Problema pobl = new Problema();
                    pobl.setTab(tablero_4);
                    addProblema(pobl);
                    pobl.setJugada_ganadora("f8=D++");

  //PROBLEMA 5
                Tablero tablero_5 = new Tablero();
                Pieza p_51 = new Caballo();
                Casilla casilla_51 = new Casilla('d', 7);
                p_51.setColor(Color.BLANCO);
                p_51.setTab(tablero_5);
                casilla_51.addPieza(p_51);
                tablero_5.getMapa()[7][3] = casilla_51;

                Pieza p_52 = new Caballo();
                Casilla c_52 = new Casilla('e', 7);
                p_52.setCas(c_52);
                p_52.setColor(Color.NEGRO);
                p_52.setTab(tablero_5);
                c_52.addPieza(p_52);
                tablero_5.getMapa()[7][4] = c_52;

                Pieza p_53 = new Torre();
                Casilla c_53 = new Casilla('f', 7);
                p_53.setCas(c_53);
                p_53.setColor(Color.NEGRO);
                p_53.setTab(tablero_5);
                c_53.addPieza(p_53);
                tablero_5.getMapa()[7][5] = c_53;

                Pieza p_54 = new Torre();
                Casilla c_54 = new Casilla('a', 6);
                p_54.setCas(c_54);
                p_54.setColor(Color.BLANCO);
                p_54.setTab(tablero_5);
                c_54.addPieza(p_54);
                tablero_5.getMapa()[6][0] = c_54;

                Pieza p_55 = new Peon();
                Casilla c_55 = new Casilla('d', 6);
                p_55.setCas(c_55);
                p_55.setColor(Color.BLANCO);
                p_55.setTab(tablero_5);
                c_55.addPieza(p_55);
                tablero_5.getMapa()[6][3] = c_55;

                Pieza p_56 = new Rey();
                Casilla c_56 = new Casilla('e', 6);
                p_56.setCas(c_56);
                p_56.setColor(Color.NEGRO);
                p_56.setTab(tablero_5);
                c_56.addPieza(p_56);
                tablero_5.getMapa()[6][4] = c_56;

                Pieza p_57 = new Peon();
                Casilla c_57 = new Casilla('f', 6);
                p_57.setCas(c_57);
                p_57.setColor(Color.BLANCO);
                p_57.setTab(tablero_5);
                c_57.addPieza(p_57);
                tablero_5.getMapa()[6][5] = c_57;

                Pieza p_58 = new Peon();
                Casilla c_58 = new Casilla('e', 5);
                p_58.setCas(c_58);
                p_58.setColor(Color.NEGRO);
                p_58.setTab(tablero_5);
                c_58.addPieza(p_58);
                tablero_5.getMapa()[5][4] = c_58;

                Pieza p_59 = new Rey();
                Casilla c_59 = new Casilla('e', 2);
                p_59.setCas(c_59);
                p_59.setColor(Color.BLANCO);
                p_59.setTab(tablero_5);
                c_59.addPieza(p_59);
                tablero_5.getMapa()[2][4] = c_59;

                Pieza p_510 = new Torre();
                Casilla c_510 = new Casilla('d', 0);
                p_510.setCas(c_510);
                p_510.setColor(Color.BLANCO);
                p_510.setTab(tablero_5);
                c_510.addPieza(p_510);
                tablero_5.getMapa()[0][3] = c_510;

                Problema po5 = new Problema();
                po5.setTab(tablero_5);
                addProblema(po5);
                po5.setJugada_ganadora("dxe8=C++");

    //PROBLEMA 6
                Tablero tablero_6 = new Tablero();
                Pieza p_61 = new Rey();
                Casilla casilla_61 = new Casilla('c', 7);
                p_61.setColor(Color.NEGRO);
                p_61.setTab(tablero_6);
                casilla_61.addPieza(p_61);
                tablero_6.getMapa()[7][2] = casilla_61;

                Pieza p_62 = new Torre();
                Casilla casilla_62 = new Casilla('d', 7);
                p_62.setColor(Color.NEGRO);
                p_62.setTab(tablero_6);
                casilla_62.addPieza(p_62);
                tablero_6.getMapa()[7][3] = casilla_62;

                Pieza p_63 = new Dama();
                Casilla casilla_63 = new Casilla('a', 3);
                p_63.setColor(Color.BLANCO);
                p_63.setTab(tablero_6);
                casilla_63.addPieza(p_63);
                tablero_6.getMapa()[3][0] = casilla_63;

                Pieza p_64 = new Alfil();
                Casilla casilla_64 = new Casilla('g', 2);
                p_64.setColor(Color.BLANCO);
                p_64.setTab(tablero_6);
                casilla_64.addPieza(p_64);
                tablero_6.getMapa()[1][6] = casilla_64;

                Pieza p_65 = new Rey();
                Casilla casilla_65 = new Casilla('g', 1);
                p_65.setColor(Color.BLANCO);
                p_65.setTab(tablero_6);
                casilla_65.addPieza(p_65);
                tablero_6.getMapa()[1][6] = casilla_65;

                Problema po6 = new Problema();
                po6.setTab(tablero_6);
                addProblema(po6);
                po6.setJugada_ganadora("Dc6++");

    //PROBLEMA 7
                Tablero tablero_7 = new Tablero();
                Pieza p_71 = new Torre();
                Casilla casilla_71 = new Casilla('d', 7);
                p_71.setColor(Color.NEGRO);
                p_71.setTab(tablero_7);
                casilla_71.addPieza(p_71);
                tablero_7.getMapa()[7][3] = casilla_71;

                Pieza p_72 = new Peon();
                Casilla casilla_72 = new Casilla('b', 6);
                p_72.setColor(Color.NEGRO);
                p_72.setTab(tablero_7);
                casilla_72.addPieza(p_72);
                tablero_7.getMapa()[6][1] = casilla_72;

                Pieza p_73 = new Rey();
                Casilla casilla_73 = new Casilla('c', 6);
                p_73.setColor(Color.NEGRO);
                p_73.setTab(tablero_7);
                casilla_73.addPieza(p_73);
                tablero_7.getMapa()[6][2] = casilla_73;

                Pieza p_74 = new Peon();
                Casilla casilla_74 = new Casilla('d', 5);
                p_74.setColor(Color.NEGRO);
                p_74.setTab(tablero_7);
                casilla_74.addPieza(p_74);
                tablero_7.getMapa()[5][3] = casilla_74;

                Pieza p_75 = new Peon();
                Casilla casilla_75 = new Casilla('e', 5);
                p_75.setColor(Color.BLANCO);
                p_75.setTab(tablero_7);
                casilla_75.addPieza(p_75);
                tablero_7.getMapa()[5][4] = casilla_75;

                Pieza p_76 = new Caballo();
                Casilla casilla_76 = new Casilla('c', 4);
                p_76.setColor(Color.BLANCO);
                p_76.setTab(tablero_7);
                casilla_76.addPieza(p_76);
                tablero_7.getMapa()[4][2] = casilla_76;

                Pieza p_77 = new Torre();
                Casilla casilla_77 = new Casilla('c', 1);
                p_77.setColor(Color.BLANCO);
                p_77.setTab(tablero_7);
                casilla_77.addPieza(p_77);
                tablero_7.getMapa()[1][2] = casilla_77;

                Pieza p_78 = new Rey();
                Casilla casilla_78 = new Casilla('h', 0);
                p_78.setColor(Color.BLANCO);
                p_78.setTab(tablero_7);
                casilla_78.addPieza(p_78);
                tablero_7.getMapa()[0][7] = casilla_78;

                Problema po7 = new Problema();
                po7.setTab(tablero_7);
                addProblema(po7);
                po7.setJugada_ganadora("Cd7++");

     //PROBLEMA 8
                Tablero tablero_8 = new Tablero();
                Pieza p_81 = new Alfil();
                Casilla casilla_81 = new Casilla('f', 6);
                p_81.setColor(Color.BLANCO);
                p_81.setTab(tablero_8);
                casilla_81.addPieza(p_81);
                tablero_8.getMapa()[6][5] = casilla_81;

                Pieza p_82 = new Peon();
                Casilla casilla_82 = new Casilla('e', 5);
                p_82.setColor(Color.NEGRO);
                p_82.setTab(tablero_8);
                casilla_82.addPieza(p_82);
                tablero_8.getMapa()[5][4] = casilla_82;

                Pieza p_83 = new Rey();
                Casilla casilla_83 = new Casilla('e', 4);
                p_83.setColor(Color.NEGRO);
                p_83.setTab(tablero_8);
                casilla_83.addPieza(p_83);
                tablero_8.getMapa()[4][4] = casilla_83;

                Pieza p_84 = new Peon();
                Casilla casilla_84 = new Casilla('f', 4);
                p_84.setColor(Color.NEGRO);
                p_84.setTab(tablero_8);
                casilla_84.addPieza(p_84);
                tablero_8.getMapa()[4][5] = casilla_84;

                Pieza p_85 = new Caballo();
                Casilla casilla_85 = new Casilla('d', 3);
                p_85.setColor(Color.BLANCO);
                p_85.setTab(tablero_8);
                casilla_85.addPieza(p_85);
                tablero_8.getMapa()[3][3] = casilla_85;

                Pieza p_86 = new Peon();
                Casilla casilla_86 = new Casilla('e', 3);
                p_86.setColor(Color.NEGRO);
                p_86.setTab(tablero_8);
                casilla_86.addPieza(p_86);
                tablero_8.getMapa()[3][4] = casilla_86;

                Pieza p_87 = new Peon();
                Casilla casilla_87 = new Casilla('e', 1);
                p_87.setColor(Color.BLANCO);
                p_87.setTab(tablero_8);
                casilla_87.addPieza(p_87);
                tablero_8.getMapa()[1][4] = casilla_87;

                Pieza p_88 = new Dama();
                Casilla casilla_88 = new Casilla('a', 0);
                p_88.setColor(Color.BLANCO);
                p_88.setTab(tablero_8);
                casilla_88.addPieza(p_88);
                tablero_8.getMapa()[0][0] = casilla_88;

                Pieza p_89 = new Torre();
                Casilla casilla_89 = new Casilla('d', 0);
                p_89.setColor(Color.BLANCO);
                p_89.setTab(tablero_8);
                casilla_89.addPieza(p_89);
                tablero_8.getMapa()[0][3] = casilla_89;

                Pieza p_810 = new Rey();
                Casilla casilla_810 = new Casilla('g', 0);
                p_810.setColor(Color.BLANCO);
                p_810.setTab(tablero_8);
                casilla_810.addPieza(p_810);
                tablero_8.getMapa()[0][6] = casilla_810;

                Problema po8 = new Problema();
                po8.setTab(tablero_8);
                addProblema(po8);
                po8.setJugada_ganadora("Cxe6++");

     //PROBLEMA 9
            Tablero tablero_9 = new Tablero();

            Pieza p_91 = new Torre();
            Casilla casilla_91 = new Casilla('f', 7);
            p_91.setColor(Color.NEGRO);
            p_91.setTab(tablero_9);
            casilla_91.addPieza(p_91);
            tablero_9.getMapa()[7][5] = casilla_91;

            Pieza p_92 = new Rey();
            Casilla casilla_92 = new Casilla('g', 7);
            p_92.setColor(Color.NEGRO);
            p_92.setTab(tablero_9);
            casilla_92.addPieza(p_92);
            tablero_9.getMapa()[7][6] = casilla_92;

            Pieza p_93 = new Peon();
            Casilla casilla_93 = new Casilla('h', 5);
            p_93.setColor(Color.BLANCO);
            p_93.setTab(tablero_9);
            casilla_93.addPieza(p_93);
            tablero_9.getMapa()[5][7] = casilla_93;

            Pieza p_94 = new Caballo();
            Casilla casilla_94 = new Casilla('g', 4);
            p_94.setColor(Color.BLANCO);
            p_94.setTab(tablero_9);
            casilla_94.addPieza(p_94);
            tablero_9.getMapa()[4][6] = casilla_94;

            Pieza p_95 = new Alfil();
            Casilla casilla_95 = new Casilla('b', 1);
            p_95.setColor(Color.BLANCO);
            p_95.setTab(tablero_9);
            casilla_95.addPieza(p_95);
            tablero_9.getMapa()[1][1] = casilla_95;

            Pieza p_96 = new Rey();
            Casilla casilla_96 = new Casilla('c', 0);
            p_96.setColor(Color.BLANCO);
            p_96.setTab(tablero_9);
            casilla_96.addPieza(p_96);
            tablero_9.getMapa()[0][2] = casilla_96;

            Problema po9 = new Problema();
            po9.setTab(tablero_9);
            addProblema(po9);
            po9.setJugada_ganadora("h7++");

     //PROBLEMA 10
                Tablero tablero_10 = new Tablero();
                Pieza pieza_1 = new Rey();
                Casilla casil_1 = new Casilla('c', 7);
                pieza_1.setCas(casil_1);
                pieza_1.setColor(Color.NEGRO);
                pieza_1.setTab(tablero_10);
                casil_1.addPieza(pieza_1);
                tablero_10.getMapa()[7][2] = casil_1;

                Pieza pieza_2 = new Torre();
                Casilla casil_2 = new Casilla('d', 7);
                pieza_2.setCas(casil_2);
                pieza_2.setColor(Color.NEGRO);
                pieza_2.setTab(tablero_10);
                casil_2.addPieza(pieza_2);
                tablero_10.getMapa()[7][3] = casil_2;

                Pieza pieza_3 = new Peon();
                Casilla casil_3 = new Casilla('c', 6);
                pieza_3.setCas(casil_3);
                pieza_3.setColor(Color.NEGRO);
                pieza_3.setTab(tablero_10);
                casil_3.addPieza(pieza_3);
                tablero_10.getMapa()[6][2] = casil_3;

                Pieza pieza_4 = new Torre();
                Casilla casil_4 = new Casilla('g', 6);
                pieza_4.setCas(casil_4);
                pieza_4.setColor(Color.BLANCO);
                pieza_4.setTab(tablero_10);
                casil_4.addPieza(pieza_4);
                tablero_10.getMapa()[6][6] = casil_4;

                Pieza pieza_5 = new Peon();
                Casilla casil_5 = new Casilla('d', 5);
                pieza_5.setCas(casil_5);
                pieza_5.setColor(Color.BLANCO);
                pieza_5.setTab(tablero_10);
                casil_5.addPieza(pieza_5);
                tablero_10.getMapa()[5][3] = casil_5;

                Pieza pieza_6 = new Torre();
                Casilla casil_6 = new Casilla('b', 0);
                pieza_6.setCas(casil_6);
                pieza_6.setColor(Color.BLANCO);
                pieza_6.setTab(tablero_10);
                casil_6.addPieza(pieza_6);
                tablero_10.getMapa()[0][1] = casil_6;


                Pieza pieza_7 = new Rey();
                Casilla casil_7 = new Casilla('g', 0);
                pieza_7.setCas(casil_7);
                pieza_7.setColor(Color.BLANCO);
                pieza_7.setTab(tablero_10);
                casil_7.addPieza(pieza_7);
                tablero_10.getMapa()[0][6] = casil_7;

                Problema prob = new Problema();
                prob.setTab(tablero_10);
                addProblema(prob);
                prob.setJugada_ganadora("Txc7++");

    }
}
