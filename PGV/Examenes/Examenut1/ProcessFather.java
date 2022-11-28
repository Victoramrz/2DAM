package PGV.Examenes.Examenut1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessFather {
    public static void main(String[] args) {
        //Recuerdo que mis rutas relativas son dentro de un proyecto dentro de carpetas
        ProcessBuilder pb = new ProcessBuilder("cmd","/C","taskmgr.exe");
        ProcessBuilder pbjar= new ProcessBuilder("cmd", "/C", "java -jar src\\PGV\\Examenes\\Examenut1\\Hijojar.jar");
        ProcessBuilder pbbat = new ProcessBuilder("src\\PGV\\Examenes\\Examenut1\\process3.bat");
        try {
            Process prexe= pb.start();
            Process prjar= pbjar.start();
            Process prbat= pbbat.start();
            InputStream is = prjar.getInputStream();
		    BufferedReader br = new BufferedReader(new InputStreamReader(is));
		    String linea;
            String name="";
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                name=linea;
            }
            OutputStream os = prbat.getOutputStream();
			os.write((name+"\n").getBytes());	
			os.flush();
            InputStream is2 = prbat.getInputStream();
		    BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
		    String linea2;
            while ((linea2 = br2.readLine()) != null) {
                System.out.println(linea2);
            }
            prexe.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
