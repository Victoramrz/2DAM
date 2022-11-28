package AED.Ficheros.Actividad2;

import java.io.Serializable;

public class persona implements Serializable{
    //Parte 2.1a
    String nombre;
    String DNI;
    int edad;
    double salario;
    persona(String DNI){
        nombre="";
        this.DNI=DNI;
        edad=0;
        salario=0;
    }
    public String getDNI() {
        return DNI;
    }
    public int getEdad() {
        return edad;
    }
    public String getNombre() {
        return nombre;
    }
    public double getSalario() {
        return salario;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
