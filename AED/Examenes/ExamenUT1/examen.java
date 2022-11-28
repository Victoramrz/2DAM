package AED.Examenes.ExamenUT1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class examen {
    final static int n=(int) (Math.random()*20)+1;//Es tu numero random ;D
    public static void main(String[] args) {        
        File fileobj = new File("src\\AED\\Examenes\\ExamenUT1\\Seguro.obj");
        if (!fileobj.exists()) {
            try {
                if (fileobj.createNewFile()) {
                    Print("Documento creado "+fileobj.getName()+" con exito");
                } else {
                    Print("Documento ya existe");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writefileobj(fileobj);
        File filedat = new File("src\\AED\\Examenes\\ExamenUT1\\SeguroDirecto.dat");
        if (!filedat.exists()) {
            try {
                if (filedat.createNewFile()) {
                    Print("Documento creado "+filedat.getName()+" con exito");
                } else {
                    Print("Documento ya existe");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        lecturaobj.main(args,fileobj,filedat);
        modifarfiledat(filedat);
        readfiledat.main(args,filedat);
        
    }
    private static void modifarfiledat(File filedat) {
        Scanner sc = new Scanner(System.in);
        try {
            RandomAccessFile raf = new RandomAccessFile(filedat, "rw"); 
            int poliza=-1;
            int position=-1;
            do {
                Print("Introduce la poliza del usuario");
                poliza=sc.nextInt();
                position=Existe(poliza,raf);
            } while (position<-1);
            position=position+lecturaobj.Poliza+lecturaobj.Cliente+lecturaobj.Matricula;
            raf.seek(position);
            double Cuota=raf.readDouble();
            Cuota=Cuota*(1-0.15);
            raf.writeDouble(Cuota);
            sc.close();
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int Existe(int poliza, RandomAccessFile raf) {
        int distintos=0;
        int position=-1;
        try {
            for (int i = 0;i < raf.length();i=(i+lecturaobj.tamaño_registro)) {
                raf.seek(i);
                if (poliza==raf.readInt()) {
                    position=i;
                    Print("Poliza encontrada");
                    return position;
                } else {
                    distintos++;
                }
            }
            if (distintos>0) {
            Print("La poliza no ha sido encontrado pruebe otro");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return position;
    }
    private static void Writefileobj(File fileobj) {
        Integer[] Polizas={2020,3015};
        String[] nombre={"Luisa ","Iker ","Pique ","Sergio ","Pedri ","Armando "};
        String [] apellidos={"Ramos","Ramirez","Berrio","Paredes","Casillas","Artiles"};
        String[] Matricula_parte_numerica={"2889","6998"};
        String[] Matricula_parte_letra={"GC","BX","CRM","ADF","DEF",""};
        Double[] Cuota={302.25,520.50};
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileobj));
            for (int i = 0; i != n; i++) {
                Seguro seguro = new Seguro();
                if (Polizas.length-1<i) {
                    seguro.setPoliza((int) (Math.random()*n)+1);
                }else{
                    seguro.setPoliza(Polizas[i]);
                }
                seguro.setCliente(nombre[(int) (Math.random()*nombre.length)]+apellidos[(int) (Math.random()*apellidos.length)]);
                if (Matricula_parte_numerica.length-1<i) {
                    seguro.setMatricula(Matricula_parte_letra[(int) (Math.random()*Matricula_parte_letra.length)]+((int) (Math.random()*1000)+1)+Matricula_parte_letra[(int) (Math.random()*Matricula_parte_letra.length)]);
                }else{
                    seguro.setMatricula(Matricula_parte_letra[i]+Matricula_parte_numerica[i]+Matricula_parte_letra[i]);
                }
                if (Cuota.length-1<i) {
                    seguro.setCuota((Math.random()*1000));
                } else {
                    seguro.setCuota(Cuota[i]);
                }
                oos.writeObject(seguro);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void Print(String Text) {
        System.out.println(Text);
    }
}
