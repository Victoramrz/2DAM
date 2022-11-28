package AED.Manejo_conectores.Actividad6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oracle216 {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "1234");
            con.setAutoCommit(false);
            Statement sentence=con.createStatement();
            File file = new File("src\\AED\\Manejo_conectores\\Actividad6\\inserts.sql");
			if (!file.exists()) {
				System.out.println("No existe");
			} else {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String myquery = "";
				while ((myquery=br.readLine())!=null) {
					sentence.executeUpdate(myquery);
				}
                System.out.println("/--------------------------------------------------------------------------------------------------------------------------------------------------------------/");
				ResultSet resul = sentence.executeQuery("SELECT * FROM proovedor");
            	while (resul.next()!=false){
					System.out.println(resul.getString(1)+" "+resul.getString(2)+" "+resul.getString(3)+" "+resul.getString(4)+" "+resul.getInt(5));
            	}
				System.out.println("/--------------------------------------------------------------------------------------------------------------------------------------------------------------/");
				resul = sentence.executeQuery("SELECT * FROM product");
            	while (resul.next()!=false){
					System.out.println(resul.getString(1)+" "+resul.getString(2)+" "+resul.getInt(3)+" "+resul.getInt(4)+" "+resul.getString(5));
            	}
			    br.close();
                File Filesent = new File("src\\AED\\Manejo_conectores\\Actividad6\\sentaciasOracle.sql");
				if (!Filesent.exists()) {
					System.out.println("No existe");
				} else {
					br = new BufferedReader(new FileReader(Filesent));
					String sent = "";
					if ((sent=br.readLine())!=null) {
						System.out.println("/--------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+" Nombre Producto: "+resul.getString(2)+ " Precio: "+resul.getInt(3));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/--------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+" Telefono : "+resul.getString(2));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/--------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Producto: "+resul.getString(1));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Code Proovedor: "+resul.getString(1)+" Nombre Producto: "+resul.getString(2)+ " Precio: "+resul.getInt(3));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/--------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+ " Numero de producto: "+resul.getInt(2)+" Media: "+resul.getInt(3));
						}
					}
					if ((sent=br.readLine())!=null) {
						System.out.println("/--------------------------------------------------------------------------------------------------------------------------------------------------------------/");
						resul = sentence.executeQuery(sent);
						while (resul.next()!=false) {
							System.out.println("Nombre Proovedor: "+resul.getString(1)+ " Direccion: "+resul.getString(2)+" Telefono: "+resul.getString(3)+" Stock: "+resul.getInt(4));
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
