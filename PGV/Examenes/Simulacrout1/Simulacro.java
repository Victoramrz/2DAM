package PGV.Examenes.Simulacrout1;
import java.io.*;
import java.util.Scanner;

public class Simulacro {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		try {
			Process proc1 = new ProcessBuilder("cmd", "/C", "msconfig").start();
			Process proc2 = new ProcessBuilder("cmd", "/C","java -jar src\\PGV\\Examenes\\Simulacrout1\\jar.jar").start();
			System.out.println("Introduzca la ruta completa de la carpeta sin el C:\\");
			String line =sc.nextLine();
			OutputStream os = proc2.getOutputStream();
			os.write((line+"\n").getBytes());	//o path completo seg�n jar
			os.flush();				
			/*Process child = Runtime.getRuntime().exec("cmd /C dir "+"C:\\"+line);
			InputStream is2 = child.getInputStream();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
			String linea2;
			while ((linea2 = br2.readLine()) != null) {
				System.out.println(linea2);
			}*/
			proc1.destroy();
		} catch (IOException e) {
			System.out.println("Error I/O, Ojo, fichero");
		}
		sc.close();
	}
}
