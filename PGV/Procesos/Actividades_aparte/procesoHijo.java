package PGV.Procesos.Actividades_aparte;

import java.util.Scanner;

public class procesoHijo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Bienvenido "+ nombre);
        sc.close();
    }
}
