package AED.Actividades_aparte;

import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Alumnomain {
    public static void main(String[] args) {
        File f= new File("./datos.txt");
		
		ObjectInputStream datoent;
		
		try {
			FileOutputStream fo= new FileOutputStream(f);
			ObjectOutputStream datosal =new ObjectOutputStream(fo);
			
			String [] nombre = {"Gru��n","Mocoso","Mudito","Feliz"};
			int[]edades= {38,21,45,100};
			
			Alumno Alumno;
			
			for (int i=0;i<nombre.length;i++){
				Alumno= new Alumno (nombre[i],edades[i]);
				datosal.writeObject(Alumno);	
			}
			
			datosal.close();
			
			FileInputStream fin= new FileInputStream(f);

			datoent =new ObjectInputStream(fin);
						
			while (true){
			Alumno = (Alumno)	datoent.readObject();
			System.out.print("Nombre: " + Alumno.getNombre() + " Edad: " + Alumno.getEdad() + "\n");
			}			
			
		} catch (FileNotFoundException e) {
			System.out.print("Archivo no encontrado.");
		} catch (EOFException e) {
			System.out.print("\nTermino la lectura del fichero.");
		} catch (ClassNotFoundException e) {
			System.out.print("Clase  no encontrada.");
		} catch (IOException e) {
			System.out.print("Error de Entrada/Salida");
		}

		
    }
}
