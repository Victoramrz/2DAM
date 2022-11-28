package AED.Manejo_conectores.Actividad6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQL6 {
    
    public static void main(String[] args) {
        try {
			//Sentencias para la conexión
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Empresa","openpg","openpgpwd");
			con.setAutoCommit(false);
			Statement sentence=con.createStatement();
			//Probar diferentes sentencias
			//int r1=sentence.executeUpdate("CREATE table alu2 (nombre, varchar2(10)");
			//sentence.executeUpdate("Insert into alumnos values (44,'Luisa')");
            File file = new File("src\\AED\\Manejo_conectores\\Actividad6\\inserts.sql");
			if (!file.exists()) {
				System.out.println("No existe");
			} else {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String informacion = "";
				while ((informacion=br.readLine())!=null) {
					sentence.execute(informacion);
				}
				System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
				ResultSet resul = sentence.executeQuery("SELECT * FROM proovedor");
            	while (resul.next()!=false){
					System.out.println(resul.getString(1)+" "+resul.getString(2)+" "+resul.getString(3)+" "+resul.getString(4)+" "+resul.getInt(5));
            	}
				System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
				resul = sentence.executeQuery("SELECT * FROM product");
            	while (resul.next()!=false){
					System.out.println(resul.getString(1)+" "+resul.getString(2)+" "+resul.getInt(3)+" "+resul.getInt(4)+" "+resul.getString(5));
            	}
				br.close();
				File Filesent = new File("src\\AED\\Manejo_conectores\\Actividad6\\sentaciasPost.sql");
				if (!Filesent.exists()) {
					System.out.println("No existe");
				} else {
					br = new BufferedReader(new FileReader(Filesent));
					String sent = "";
					if ((sent=br.readLine())!=null) {
						System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+" Nombre Producto: "+resul.getString(2)+ " Precio: "+resul.getInt(3));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+" Telefono : "+resul.getString(2));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Producto: "+resul.getString(1)+" Stock: "+resul.getString(2));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Producto: "+resul.getString(1)+ " Precio: "+resul.getInt(2));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+ " Numero de producto: "+resul.getInt(2)+" Media: "+resul.getInt(3));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+ "Direccion: "+resul.getString(2)+" Telefono: "+resul.getString(3));
						}
					}
					br.close();
				}
				resul.close();
			}
			sentence.close();
			con.close();
		} catch (FileNotFoundException e) {
			System.err.println("File no encontrado");		
		} catch (ClassNotFoundException e) {
			System.err.println("Error clase JDBC");
		} catch (SQLException e) {
			System.out.println(e);
			System.err.println("Error SQL");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
