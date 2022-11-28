package AED.Ficheros.Actividad1;

import java.io.*;
import javax.swing.JOptionPane;

public class Fichero_binario {
        public static void main(String[] args) {
        String text="50 iteraciones de contador i, u otro método";
        File doc = new File("src\\AED\\Ficheros\\Actividad1\\Binario.txt");
        if (!doc.exists()) {
            JOptionPane.showMessageDialog(null, "No existe el fichero, por favor cree el fichero");
            //No se puede usar system.exit(0) porque sales de todo el programa
            return;
        }else{
            try {
                //Y escribo, no leo
                FileOutputStream fos = new FileOutputStream(doc);
                for (int i = 0; i < text.length(); i++) {
                    //Menu_Act1.Imprimir(""+((""+text.charAt(i)).getBytes()));
                    fos.write(((""+text.charAt(i)).getBytes()));
                }
                fos.close();
                FileInputStream fis = new FileInputStream(doc);
                String mensaje="";
                int valor_letra;
		        while ((valor_letra=fis.read())!=-1) {
			        mensaje=mensaje+""+(char)valor_letra;
		        }
                Menu_Act1.Imprimir(mensaje);
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
