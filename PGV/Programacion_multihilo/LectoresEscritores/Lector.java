package PGV.Programacion_multihilo.LectoresEscritores;

public class Lector extends Thread{
    String text="";
    MyBuffer myBuffer;
    Lector(MyBuffer myBuffer){
        this.myBuffer=myBuffer;
    }
    public void leer() {
        try {
            Thread.sleep(((int)(Math.random()*1000)));
            text=MyBuffer.reader();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (text==null) {
            System.out.println("Soy el "+this.getName()+" y no consegui leer :_C ");
        } else {
            System.out.println("Soy el "+this.getName()+" y lei: "+text);
        }
        
    }
}
