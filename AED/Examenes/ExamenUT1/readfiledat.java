package AED.Examenes.ExamenUT1;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class readfiledat {
    public static void main(String[] args, File filedat) {
        try {
            RandomAccessFile raf = new RandomAccessFile(filedat, "r");
            examen.Print("/-------------------------------------------------------------------------------------------------------------------------------/");
            
            int position_register=0;
            for (int i = 0; i < raf.length();i=(i+lecturaobj.tamaño_registro)) {
                position_register=0;
                raf.seek(position_register+i);
                examen.Print("Poliza: "+raf.readInt()+"\n");
                position_register+=lecturaobj.Poliza;
                raf.seek(position_register+i);
                String cliente="";
                for (int j = position_register+i; j <= position_register+i+lecturaobj.Cliente; j++) {
                    char caracter = raf.readChar(); 
                    if (caracter!=0) {
                        cliente= cliente + caracter;
                    } else {
                        j=position_register+i+lecturaobj.Cliente;   
                    }
                }
                examen.Print("Cliente: "+cliente+"\n");
                position_register+=lecturaobj.Cliente;
                String matricula="";
                raf.seek(position_register+i);
                for (int j = position_register+i; j < position_register+i+lecturaobj.Matricula; j++) {
                    char caracter = raf.readChar(); 
                    if (caracter!=0) {
                        matricula= matricula + caracter;
                    } else {
                        j=position_register+i+lecturaobj.Cliente;   
                    }
                }
                examen.Print("Matricula: "+matricula+"\n");
                position_register+=lecturaobj.Matricula;
                raf.seek(position_register+i);
                examen.Print("Cuota: "+raf.readDouble()+"\n");
            }   
            raf.close();
        } catch (EOFException e){
            examen.Print("Aprobado minimo");
        }catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
