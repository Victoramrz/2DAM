package AED.Ficheros.Actividad1;

import java.util.Scanner;

public class Menu_Act1 {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean volver;
        do {
            volver=false;
            System.out.println("Buenas si desea ver la parte a pon A, si quiere ver la parte b pon B, si quiere ver la parte c pon C, si quiere ver la parte d pon D, si quiere ver la parte e pon E y si quieres salir pon Fin");
            String eleccion=sc.nextLine().toLowerCase().trim();
            switch(eleccion){ 
                case "a":
                    Listafichero.main(args);
                    volver=true;
                break;
                case "b":
                    Propiedades_ficheros.main(args);
                    volver=true;
                break;
                case "c":
                boolean error;
                do {
                    error=true;
                    System.out.println("Desea ver la parte del Reader ponga reader o r, si desea ver la parte del Writer ponga writer o w y si quiere volver al menu previo ponga salir o s");
                    eleccion=sc.nextLine().trim().toLowerCase();
                    switch (eleccion) {
                        case "writer":
                        case "w":
                            Writer.main(args);
                        break;
                        case "reader":
                        case "r":
                            Reader.main(args);
                            error=true;
                        break;
                        case "salir":
                        case "s":
                            error=false;
                        break;
                        default:
                            Menu_Act1.Imprimir("Lo siento no le he entendido");
                            error=true;
                        break;
                        }   
                        
                } while (error);
                    volver=true;
                break;
                case "d":
                    Buffered.main(args);
                    volver=true;
                break;
                case "e":
                    Fichero_binario.main(args);
                    volver=true;
                break;
                case "f":
                case "fin":
                    volver=false;
                break;
            }
        } while (volver);
        sc.close();
    }
    protected static String SolitoRuta() {
        String ruta;
        do {
            Menu_Act1.Imprimir("Introduce la ruta que dese");
            ruta=sc.nextLine().trim().toLowerCase();
        } while (ruta==null||ruta=="");
        return ruta;
    }
    protected static void Imprimir(String texto){
        System.out.println(texto);
    }
}
