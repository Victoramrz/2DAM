package AED.Ficheros.Actividad1;

import java.io.*;
import javax.swing.JOptionPane;

public class Buffered {
    public static void main(String[] args) {
        File DocExit = new File("src\\AED\\Ficheros\\Actividad1\\Salida.txt");
        if (!DocExit.exists()) {
            JOptionPane.showMessageDialog(null, "No existe el fichero, por favor cree el fichero");
            //No se puede usar system.exit(0) porque sales de todo el programa
            return;
        }else{
            FileReader fr;
            BufferedReader br;
            try {
                String cadena;
                fr = new FileReader(DocExit);
                br = new BufferedReader(fr);
                while ((cadena = br.readLine())!=null) {
                    System.out.println(cadena);
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File DocInt = new File("src\\AED\\Ficheros\\Actividad1\\meta.txt");
        if (!DocInt.exists()) {
            try {
                DocInt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
           Menu_Act1.Imprimir("Se ha creado el documento");
        }
        try {
            FileWriter fw = new FileWriter(DocInt);
            BufferedWriter bw = new BufferedWriter(fw);
            String nombresJuntos = "Paco,Juan,Iriome,Ainhoa,Peng,Ximing,Victor,Jose";
            String[] nomSeparados= nombresJuntos.split(",");
            for (int i = 0; i < nomSeparados.length; i++) {
                bw.write("Fila "+(i+1)+": "+nomSeparados[i]);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) { 
            e.printStackTrace();
        }


    }
}
