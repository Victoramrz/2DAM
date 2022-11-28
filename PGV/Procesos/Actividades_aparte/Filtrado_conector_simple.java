package PGV.Procesos.Actividades_aparte;

import java.io.*;

public class Filtrado_conector_simple {
    
    public static void main(String[] args) {
    //Hijo es el tasklist y el padre este conector
        try {
            //No se ponte "start" porque si no sale en el cmd
            Process proc = new ProcessBuilder("cmd","/C","tasklist").start();
            //El inputStream recoge el proceso tasklist en este caso para ver
            InputStream is = proc.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea=br.readLine())!=null) {
                if (linea.contains("svchost")) {
                    System.out.println(linea);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}