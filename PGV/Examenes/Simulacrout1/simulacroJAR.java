package PGV.Examenes.Simulacrout1;
import java.io.*;
import java.util.Scanner;

public class simulacroJAR {
	public static void main(String[] args) throws IOException {

		// El m�todo canonicalPath simplifica el acceso a la carpeta
		Scanner sc = new Scanner(System.in);
		String linea = sc.nextLine();
		//String linea = "C:\\Hide";
		String carpeta =linea;
		File f = new File(carpeta);
		String[] listaFila = f.list();

		for (int i = 0; i < listaFila.length; i++) {
			try {

				Process proc = new ProcessBuilder("cmd", "/C", "src\\PGV\\Examenes\\Simulacrout1\\hide.bat")
						.start();
				OutputStream os = proc.getOutputStream();

				os.write((carpeta + "\\" + listaFila[i] + "\n").getBytes());
				os.flush();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}
			sc.close();
		}
	}
}
