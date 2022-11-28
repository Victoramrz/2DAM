package PGV.Examenes.Examenut1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Hijojar {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd","/C","hostname");
        try {
            Process pr = pb.start();
            InputStream is = pr.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
