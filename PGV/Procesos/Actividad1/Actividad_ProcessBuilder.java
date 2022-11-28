package PGV.Procesos.Actividad1;

import java.io.IOException;

public class Actividad_ProcessBuilder {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder().command("notepad.exe");
        ProcessBuilder pb1 = new ProcessBuilder("cmd","/C","start","src\\PGV\\Procesos\\Actividad1\\ventana.jar");
        ProcessBuilder pb2 = new ProcessBuilder("cmd","/C","start","src\\PGV\\Procesos\\ejemplo.bat");
        try {
            Process pl=pb.start();
            Process pl1=pb1.start();
            Process pl2=pb2.start();
            pl.exitValue();
            pl1.exitValue();
            pl2.exitValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
