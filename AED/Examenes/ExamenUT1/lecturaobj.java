package AED.Examenes.ExamenUT1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class lecturaobj {
    //Estructura del RandomAccess 
    final static int Poliza= 4 ;//Int 4
    final static int Cliente=  36 ;// String 18*2 =36
    final static int Matricula= 36 ;// String 18*2 =36
    final static int Cuota= 8 ;// Double 8
    final static int tamaño_registro=lecturaobj.Poliza+lecturaobj.Cliente+lecturaobj.Matricula+lecturaobj.Cuota;
    //Total de cada registro 84
    
    public static void main(String[] args, File fileobj, File filedat) {
        try {
            FileInputStream fis = new  FileInputStream(fileobj);
            ObjectInputStream ois = new ObjectInputStream(fis);
            RandomAccessFile raf = new RandomAccessFile(filedat, "rw");
            for (int i = 0; i < fileobj.length(); i++) {
                Seguro seguro;
                while ((seguro=(Seguro)ois.readObject())!=null){
                    examen.Print("Poliza: "+seguro.getPoliza()+"\nCliente:"+seguro.getCliente().toString()+"\nMatricula: "+seguro.getMatricula().toString()+"\nCuota: "+seguro.getCuota());
                    raf.writeInt(seguro.getPoliza());
                    StringBuffer sb = new StringBuffer(seguro.getCliente().toString());
                    sb.setLength(18);
                    raf.writeChars(sb.toString());
                    sb= new StringBuffer(seguro.getMatricula().toString());
                    sb.setLength(18);
                    raf.writeChars(sb.toString());
                    raf.writeDouble(seguro.getCuota());
                }
            }
            fis.close();
            ois.close();
            raf.close();
        } catch(EOFException e){
            examen.Print("Apruebame");
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
