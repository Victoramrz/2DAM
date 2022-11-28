package AED.Ficheros.Actividad2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Escritor_Object {
    public static void main(String[] args) {
        //Parte 2.1b
        ArrayList<persona> ListaPersona= new ArrayList<persona>();
        Scanner sc = new Scanner(System.in);
        File doc = new File("src\\AED\\Ficheros\\Actividad2\\Objets\\Persona.obj");
        try {
            ObjectOutputStream Dataout = new ObjectOutputStream(new FileOutputStream(doc));
            int cantidad=0;
            do {
                Imprimir("Introduce la cantidad de alumnos que quieres registrar");
                cantidad=sc.nextInt();
            } while (cantidad<1);
            sc.nextLine();
            for (int i = 0; i < cantidad; i++) {
                    String nombre=null;
                do {
                    Imprimir("Introduce el nombre del alumno");
                    nombre=sc.nextLine().trim().toLowerCase();
                } while (nombre==null|| nombre =="");
                String DNI=null;
                do {
                    Imprimir("Introduce el DNI del alumno");
                    DNI=sc.nextLine().trim().toLowerCase();
                } while (DNI==null|| DNI =="");
                int edad=0;
                do {
                    Imprimir("Introduce la edad del alumno");
                    edad=sc.nextInt();
                } while (edad<=0);
                sc.nextLine();
                double salario=0;
                do {
                    Imprimir("Introduce el salario del alumno");
                    salario=sc.nextDouble();
                } while (salario <=0);
                sc.nextLine();
                persona person = new persona(DNI);
                person.setEdad(edad);
                person.setNombre(nombre);
                person.setSalario(salario);
                ListaPersona.add(person);
            }
            for (int i = 0; i < ListaPersona.size(); i++) {
                Dataout.writeObject(ListaPersona.get(i));
            }
            Dataout.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(doc));
            File docDat=new File("src\\AED\\Ficheros\\Actividad2\\Objets\\Persona.DAT");
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(docDat));
            boolean seguir= true;
            try {
                persona person=(persona) ois.readObject();
                int uso_unico=0;
                do {
                    Imprimir("/------------------------------------------------------------------------------------------------------------------------------------------/");
                    Imprimir("Nombre: "+person.getNombre()+"\n"+"DNI:"+person.getDNI()+"\n"+"Edad: "+person.getEdad()+"\n"+"Salario: "+person.getSalario()+" euros");
                    dos.writeChars(person.getDNI()+";"+person.getNombre()+";"+person.getEdad()+";"+person.getSalario());
                    if(uso_unico!=cantidad){
                        dos.writeChar(';');
                        uso_unico++;
                    }
                    
                    try {
                        person =(persona) ois.readObject();
                        seguir=true;
                    } catch (Exception e) {
                        Imprimir("/------------------------------------------------------------------------------------------------------------------------------------------/");
                        seguir=false;
                    }
                } while (seguir);
            } catch (ClassNotFoundException e) {
                System.out.print("Clase  no encontrada");
            }
            dos.close();
            ois.close();
            //Read Data
            FileInputStream fis =new FileInputStream(docDat);
            DataInputStream dis = new DataInputStream(fis);
            int count = fis.available();  
            byte[] ary = new byte[count];  
            dis.read(ary);
            String texto="";
            for (byte bt : ary) {  
                if ((char) bt!=0) {
                    char k = (char) bt;
                    texto= texto + k;
                } else {
                    
                }
            }
            String[] datos_separados = texto.split(";");
            String localizadores="";
            int menores=0;
            for (int i = 0; i < (datos_separados.length);) {
                String text=datos_separados[i+2];
                int edad= Integer.parseInt(text);
                if (edad>=18) {
                    localizadores=localizadores + ";"+(i);
                } else {
                    menores++;
                }
                i=i+4;
            }
            String[] localizadores_separados = localizadores.split(";");
            if (menores==cantidad) {
                Imprimir("Todos son menores");
            } else {
                for (int i = 0; i < (localizadores_separados.length-1); i++) {
                    int position=Integer.parseInt(localizadores_separados[Integer.parseInt(datos_separados[i])]);
                    Imprimir("Nombre: "+datos_separados[position]+" DNI: "+datos_separados[position+1]+" Edad: "+datos_separados[position+2]+" Salario: "+datos_separados[position+3]);
                }
            }
            
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
    protected static void Imprimir(String texto){
        System.out.println(texto);
    }
    
}
