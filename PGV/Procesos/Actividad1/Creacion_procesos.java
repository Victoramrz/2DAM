package PGV.Procesos.Actividad1;

import java.util.Scanner;

public class Creacion_procesos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean seguir;
        do {
            seguir= false;
            Imprimir("Quieres usar el Runtime pongo r, quieres usar ProcessBuilder pon p y si quieres salir por s");
            String eleccion=sc.nextLine().toLowerCase().trim();
            switch (eleccion) {
                case "runtime":
                case "r":     
                    seguir=true;
                    Actividad_Runtime.main(args);
                break;
                case "processbuilder":
                case "p":
                    Actividad_ProcessBuilder.main(args);
                    seguir=true;
                break;
                case "salir":
                case "s":
                case "fin":
                case "f":
                    seguir=false;
                break;
                default:Imprimir("Lo siento no lo entiendo");
            } 
        }while (seguir);
        sc.close();
    }
    protected static void Imprimir(String texto){
        System.out.println(texto);
    }
}
