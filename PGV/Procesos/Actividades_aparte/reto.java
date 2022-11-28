package PGV.Procesos.Actividades_aparte;

import java.io.*;
import java.util.Scanner;
public class reto {
    public static void main(String[] args) {
        try {
            Process pro = new ProcessBuilder ("cmd" , "/C" , "date" ) . start ( ) ;
            InputStream is = pro.getInputStream ( ) ;
            OutputStream os = pro.getOutputStream ( ) ;
            BufferedReader br = new BufferedReader ( new InputStreamReader ( is ) ) ;
            BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter ( os ) ) ;
            String linea ;
            Scanner sc = new Scanner(System.in);
            bw.write ( sc.nextLine()+"\n" ) ;
            bw.flush () ;
            while ( ( linea = br.readLine ( ) ) != null ) {
                 System.out.println ( linea ) ;
            }   
            sc.close();
        } catch ( IOException e ) {

        }   
    }
}
