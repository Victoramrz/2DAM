package AED.Ficheros.Actividad3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleados{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] Nombres={"Paco","Juan","Tamara","Arantxa","Guzman","Amber"};
        ArrayList<Integer> NumEmps= new ArrayList<>();
        String[] Telefonos={"321654789","789645321","591326478","324915657","348526791","516498753"};
        double[] Salarios={12.58,48.32,84.01,25,59.02,62.00};
        File doc = new File("src\\AED\\Ficheros\\Actividad3\\Empleados.DAT");
        try (RandomAccessFile raf = new RandomAccessFile(doc, "rw")) {
            int i = 0;
                while(i!= NumEmps.size()) {
                    int numero = (int) (Math.random()*10)+1;
                    int repetido=0;
                    for (int j = 0; j < NumEmps.size(); j++) {
                        if (numero==NumEmps.get(j)) {
                           repetido++;
                        }  
                    }
                    if(repetido==0){
                        NumEmps.add(numero);
                    }
                    i++;
                }
            for (i = 0; i < Nombres.length; i++) {
                raf.writeInt(NumEmps.get(i));//Int 32 (32*1)/8 = 4 bytes
                StringBuffer sb = new StringBuffer(Nombres[i]);
                sb.setLength(25);
                raf.writeChars(sb.toString());// Char 16 (16*25)/8 = 50 bytes
                sb=new StringBuffer(Telefonos[i]);
                sb.setLength(9);
                raf.writeChars(sb.toString());// Char 16 (16*9)/8 = 18 bytes
                raf.writeDouble(Salarios[i]);//Double 64 (64*1)/8 = 8 bytes
            }
            // Cada registro 4+50+18+8 80bytes
            int Num_emp=0;
            int localizador=-1;
            ArrayList<Integer> num_emp_read = new ArrayList<>();
            for (i = 0; i < raf.length();i=(i+80)) {
                raf.seek(i);
                int aux=raf.readInt();
                num_emp_read.add(aux);
            }
            do {
                Imprimir("Introduce el número de empleado");
                Num_emp=sc.nextInt();
                localizador=Exite(Num_emp,num_emp_read);
            } while (localizador<0);
            raf.seek(localizador);
            Imprimir("Localizador:"+raf.readInt());
            String nombre="";
            for (i=localizador+4; i < localizador+50+4; i=(i+2)) {
                raf.seek(i);
                char caracter=raf.readChar();
                if (caracter!=0) {
                    nombre+=caracter;
                }
            }
            Imprimir(nombre);
            String Telefono="";
            for (i=localizador+54; i < localizador+4+50+18; i=(i+2)) {
                raf.seek(i);
                Telefono+=raf.readChar();
            }
            Imprimir(Telefono);
            raf.seek(localizador+80-8);
            Imprimir(raf.readDouble()+"");
            Imprimir("//-----------------------------------------------------------------------------------------------------------------------------------------------------//");
            do {
                Imprimir("Introduce el número de empleado");
                Num_emp=sc.nextInt();
                localizador=Exite(Num_emp,num_emp_read);
            } while (localizador<0);
            Imprimir("¿Cuanto es el importe extra?");
            double extra = sc.nextDouble();    
            raf.seek(localizador+80-8);
            double salario_viejo=raf.readDouble();
            Imprimir("Salario anterior: "+salario_viejo);
            raf.seek(localizador+80-8);
            raf.writeDouble(extra+salario_viejo);
            raf.seek(localizador+80-8);
            Imprimir("Salario actual: "+ raf.readDouble());
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }

    private static int Exite(int Num_emp, ArrayList<Integer> num_emp_read) {
        int distintos=0;
        int localizador=-1;
        for (int i = 0;i < num_emp_read.size();i++) {
            if (Num_emp==num_emp_read.get(i)) {
                localizador=i*80;
                Imprimir("Empleado encontrado");
                return localizador;
            } else {
                distintos++;
            }
        }
        if (distintos>0) {
            Imprimir("El empleado no ha sido encontrado pruebe otro");
        }
        return localizador;
    }

    protected static void Imprimir(String Texto) {
        System.out.println(Texto);
    }    
}