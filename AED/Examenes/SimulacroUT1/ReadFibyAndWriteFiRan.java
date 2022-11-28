package AED.Examenes.SimulacroUT1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadFibyAndWriteFiRan {
    public static void main(String[] args, File fiby, File firan) {
         //Read Fiby
         try {
            FileInputStream fis = new FileInputStream(fiby);
            int count = fis.available();  
                byte[] ary = new byte[count];  
                fis.read(ary);
                String text="";
                for (byte bt : ary) {  
                    if ((char) bt!=0) {
                        char k;
                        if ((char)bt!=10) {
                            k = (char) bt;
                        } else {
                            k =';';
                        }
                        text= text + k;
                    } else {    
                    }
                }
            String[] register = text.split(";");
            //Write RandomAccessFile
            RandomAccessFile raf = new RandomAccessFile(firan, "rw");
            for (int i = 0; i < register.length; i++) {
                String[] registersplit = register[i].split("##");
                raf.writeInt(Integer.parseInt(registersplit[0]));
                StringBuffer sb = new StringBuffer(registersplit[1]);
                sb.setLength(20);
                raf.writeChars(sb.toString());
                sb=new StringBuffer(registersplit[2]);
                sb.setLength(20);
                raf.writeChars(sb.toString());
                raf.writeInt(Integer.parseInt(registersplit[3]));
                sb=new StringBuffer(registersplit[4]);
                sb.setLength(20);
                raf.writeChars(sb.toString());
            }
            raf.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
