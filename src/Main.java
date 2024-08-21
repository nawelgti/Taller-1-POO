import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] matrizCartas = crearMatrizCartas();
        inicializarCartasJuego(matrizCartas);

        System.out.println("Bienvenido al juego de cartas\n");

        boolean salir = false;
        while (!salir) {
            System.out.println("Menú principal");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Ingresa una opcion: ");
            String eleccion = leerRespuesta();

            if (eleccion.equals("1")) {
                jugar(matrizCartas);
            }
            if (eleccion.equals("2")) {
                salir = Salir();
                if (salir) {
                    System.out.println("Hasta pronto");
                    break;
                }
            }
        }

    }

    public static String[][] crearMatrizCartas() {
        return new String[12][2];
    }

    public static void agregarCartas(String[][] matrizCartas, String nombreCarta, String puntaje) {
        for (int i = 0; i < 12; i++) {
            if (matrizCartas[i][0] == null) {
                matrizCartas[i][0] = nombreCarta;
                matrizCartas[i][1] = puntaje;
            }
        }
    }

    public static int obtenerCartas() {
        //elije una carta al azar de entre 1 a la 12
        return (int)(Math.random()*12+1);
    }

    public static void inicializarCartasJuego(String[][] matrizCartas) {
        agregarCartas(matrizCartas, "'2' de Tréboles", "2");
        agregarCartas(matrizCartas, "'3' de Diamantes", "3");
        agregarCartas(matrizCartas, "'4' de Picas", "4");
        agregarCartas(matrizCartas, "'5' de Corazones", "5");
        agregarCartas(matrizCartas, "'6' de Tréboles", "6");
        agregarCartas(matrizCartas, "'7' de Diamantes", "7");
        agregarCartas(matrizCartas, "'8' de Picas", "8");
        agregarCartas(matrizCartas, "'9' de Corazones", "9");
        agregarCartas(matrizCartas, "'K' Pica", "10");
        agregarCartas(matrizCartas, "'Q' Corazón", "10");
        agregarCartas(matrizCartas, "'J' Trébol", "10");
        agregarCartas(matrizCartas, "'A' Diamante","11");
    }

    public static void jugar(String[][] matrizCartas) {
        int[] player1 = new int[3];
        int[] player2 = new int[3];

        for (int i = 0; i < 3; i++) {
            player1[i] = obtenerCartas();
            player2[i] = obtenerCartas();

            //convertir n° de carta a puntaje de esta
            if (player1[i] < 9) {
                player1[i]++;
            }
            else if (player1[i] < 12) {
                player1[i] = 10;
            }
            else if (player1[i] == 12) {
                player1[i]--;
            }

            if (player2[i] < 9) {
                player2[i]++;
            }
            else if (player2[i] < 12) {
                player2[i] = 10;
            }
            else if (player2[i] == 12) {
                player2[i]--;
            }
        }

        int puntajeP1 = (player1[0]+player1[1]+player1[2]);
        int puntajeP2 = (player2[0]+player2[1]+player2[2]);

        System.out.println("\nPuntaje jguador 1: "+puntajeP1);
        System.out.println("Puntaje jguador 2: "+puntajeP2);

        if (puntajeP1 > 20 && puntajeP2 < 20) {
            System.out.println("El jugador 2 ha ganado con un puntaje de " + puntajeP2 + " pts.\n");
        }
        else if (puntajeP2 > 20 && puntajeP1 < 20) {
            System.out.println("El jugador 1 fue el ganador con un puntaje de "+puntajeP1+" pts.\n");
        }
        else if (puntajeP2 < puntajeP1) {
            System.out.println("El jugador 1 fue el ganador con un puntaje de "+puntajeP1+" pts.\n");
        }
        else if (puntajeP1 == puntajeP2) {
            System.out.println("Ha habido un empate con un puntaje de "+puntajeP2+" pts.\n");
        }
        else {
            System.out.println("El jugador 2 ha ganado con un puntaje de " + puntajeP2 + " pts.\n");
        }
    }

    public static boolean Salir() {
        System.out.print("¿Seguro que desea salir? (SI/NO): ");
        String opcion = leerRespuesta();

        boolean salir = false;
        while (!opcion.equals("SI") && !opcion.equals("NO")) {
            System.out.print("Opcion no valida (SI/NO): ");
            opcion = leerRespuesta();
        }
        if (opcion.equals("SI")) {
            salir = true;
        }
        if (opcion.equals("NO")) {
            salir  = false;
        }
        System.out.println();
        return salir;
    }

    public static String leerRespuesta() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}