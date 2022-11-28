package PGV.Procesos.Actividad2.Parte2;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesoHijo {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd","/C","tasklist /SVC /FO LIST");
        try {
            Process pr = pb.start();
            InputStream is = pr.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            is=pr.getInputStream();
            br= new BufferedReader(new InputStreamReader(is));
            String linea="";
            while ((linea=br.readLine())!= null) {
                System.out.println(linea);
            }
            br.close();
            is.close();
        } catch (EOFException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
