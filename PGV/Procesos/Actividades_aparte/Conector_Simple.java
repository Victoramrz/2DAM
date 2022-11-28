package PGV.Procesos.Actividades_aparte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Conector_Simple {
    public static void main(String[] args) {
        //Hijo es el dir y el padre este conector
        //ProcessBuilder pb = new ProcessBuilder("cmd", "/C","start","C:\\Users\\Jake\\Desktop\\comando.bat");
        Runtime mirun = Runtime.getRuntime();
        try {
            //No se ponte "start" porque si no sale en el cmd
            //Process proc = new ProcessBuilder("cmd","/C","dir").start();
            //Process proc1= pb.start();
            //Process proc = mirun.exec("java -jar src\\PGV\\Procesos\\Actividades_aparte\\hijo.jar");//Poner las rutas relativas
            Process proc = mirun.exec("cmd /C C:\\Users\\Jake\\Desktop\\comando.bat");
            //El inputStream recoge el proceso dir en este caso para ver
            OutputStream os = proc.getOutputStream();
            os.write(("Rita\n").getBytes());
            os.flush();
            InputStream is = proc.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea=br.readLine())!=null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
