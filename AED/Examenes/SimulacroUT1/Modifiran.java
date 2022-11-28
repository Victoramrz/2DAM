package AED.Examenes.SimulacroUT1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Modifiran {
    public static void main(String[] args, File firan) {
        //Cambiar
        try {
            RandomAccessFile raf = new RandomAccessFile(firan, "rw");
            Scanner sc = new Scanner(System.in);
            int num_team=-1;
            int position=-1;
            do {
                Simulacrout1.Print("Enter the team number");
                num_team=sc.nextInt();
                int i = 0;
                while ( i < raf.length()) {
                    raf.seek(i);
                    int num_team_read=raf.readInt();
                    if(num_team==num_team_read){
                        position=i;
                        i=(int)raf.length();
                    }
                    i=(i+Simulacrout1.sizesRandom[Simulacrout1.sizesRandom.length-1]);
                }
            } while (position==-1);
            int telefone=-1;
            do {
                Simulacrout1.Print("Enter the new telefone from this team");
                telefone=sc.nextInt();
            } while (Integer.toString(telefone).length()!=9);
            position=position+Simulacrout1.sizesRandom[0]+Simulacrout1.sizesRandom[1]+Simulacrout1.sizesRandom[2];
            raf.seek(position);
            raf.writeInt(telefone);
            raf.seek(position);
            Simulacrout1.Print("New telefone: "+raf.readInt());
            sc.nextLine();
            sc.close();
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
