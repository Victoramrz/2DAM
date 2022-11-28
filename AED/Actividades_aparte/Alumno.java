package AED.Actividades_aparte;

import java.io.Serializable;

public class Alumno implements Serializable{
    private static final long serialVersionUID = 1L;
	
	String nombre = "";
	int edad=0;

	public Alumno (String nombre, int edad){
		this.nombre=nombre;
		this.edad=edad;
		
	}
	
	public void setNombre (String nombre){
		this.nombre=nombre;
	}
	
	public void setEdad(int edad){
		this.edad=edad;
	}
	
	
	public String getNombre(){
		return nombre;
	}
	
	public int getEdad(){
		return edad;
	}
}
