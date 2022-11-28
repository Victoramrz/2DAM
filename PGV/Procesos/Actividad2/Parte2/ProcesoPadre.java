package PGV.Procesos.Actividad2.Parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ProcesoPadre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Runtime run = Runtime.getRuntime();
        try {
            Process pr = run.exec("cmd /C java -jar src\\PGV\\Procesos\\Actividad2\\Parte2\\Kind.jar");
            InputStream is = pr.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea="";
            int i =0;
            int numero=-2;
            while ((linea=br.readLine())!=null) {
                if (linea.contains("svchost.exe")) {
                    numero=i;
                }
                if (i==numero||i==numero+1||i==numero+2) {
                    System.out.println(linea);
                } else if(i==numero+3){
                    System.out.println();
                }
                i++;
            }
            br.close();
            is.close();
            File file = new File("bat.bat");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write("set /p comando =\nsc qc %comando%");
            fw.flush();
            fw.close();
            ProcessBuilder pb = new ProcessBuilder("cmd","/C","bat.bat");
            Process pr2 = pb.start();
            OutputStream os = pr2.getOutputStream();
            BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(os));
            System.out.println("Introduce un servicio: ");
            String servicio= sc.nextLine();
            bw.write(servicio);
            bw.flush();
            bw.close();
            os.close();
            is=pr2.getInputStream();
            br= new BufferedReader(new InputStreamReader(is));
            linea="";
            while ((linea=br.readLine())!= null) {
                System.out.println(linea);
            }
            br.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
