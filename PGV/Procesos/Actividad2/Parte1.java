package PGV.Procesos.Actividad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Parte1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Padre e hijo
        String nombre="";
            do {
                System.out.println("Introduce la palabra que quieras");
                nombre=sc.nextLine().trim().toLowerCase();
            } while (nombre=="");
        ProcessBuilder pb = new ProcessBuilder("cmd","/C","java -jar src\\PGV\\Procesos\\Actividad2\\Kind.jar");
        //Reproductor
        ProcessBuilder pb1 = new ProcessBuilder("wmplayer.exe","C:\\Users\\Jake\\Music\\Contigo_Sebastian_Yatra_Base.mp3");
        try {
            Process proc = pb.start();
            Process proc1 = pb1.start();
            OutputStream os = proc.getOutputStream();
            os.write((nombre+"\n").getBytes());
            os.flush();
            InputStream is = proc.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea=br.readLine())!=null) {
                System.out.println(linea);
            }
            br.close();
            proc1.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
