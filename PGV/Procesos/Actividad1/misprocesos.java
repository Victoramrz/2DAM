package PGV.Procesos.Actividad1;

import java.io.IOException;

public class misprocesos {
    public static void main(String[] args)  {
        //Desde el IDE
        //ProcessBuilder pb1 = new ProcessBuilder("calc.exe");//meter el nombre de la app
        ProcessBuilder pb = new ProcessBuilder().command("notepad.exe");
        //Desde el cmd
        //ProcessBuilder pb2 = new ProcessBuilder("cmd","/C","start","src\\PGV\\Procesos\\ejemplo.bat");
        //ProcessBuilder pb2 = new ProcessBuilder("src\\PGV\\Procesos\\ejemplo.bat");
        //Lo mismo pero con RunTime
        //Runtime mirun = Runtime.getRuntime();
        //Desde consola primero ir a la localizacion y luego poner (java -jar ventana.jar)
        try {
            //Concurente == seguidos
            //Process pl=pb.start();
            //Espera hasta que se cierre el otro
            //pl.waitFor();
            //pl.destroy();
            Process pl2=pb.start();
            pl2.waitFor();
            //Process promirun=mirun.exec("C:\\Users\\Jake\\Desktop\\ventana.jar");
        } catch (IOException |InterruptedException e) {
            
        }       
    }
}