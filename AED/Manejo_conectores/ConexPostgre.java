package AED.Manejo_conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexPostgre {

	public static void main(String[] args)  {
		
		
		try {
			//Sentencias para la conexi�n
			
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/AED","openpg","openpgpwd");
						
			Statement sentence=con.createStatement();
			
			//Probar diferentes sentencias
			//int r1=sentence.executeUpdate("CREATE table alu2 (nombre, varchar2(10)");
			//int r2=sentence.executeUpdate("Insert into alumnos values (44,'Luisa')");
				
			ResultSet resul = sentence.executeQuery("SELECT * FROM departamentos");
            while (resul.next()){
                System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getString(3));
            }
            System.out.println("/----------------------------------------------------------------------------------------------------------------------------------------/");
            resul = sentence.executeQuery("SELECT * FROM empleados");
            while (resul.next()){
                System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getString(3)+" "+resul.getString(4)+" "+resul.getString(5)+" "+resul.getString(6)+" "+resul.getString(7));
            }
			
			//Cerrar
			resul.close();
			sentence.close();
			con.close();
					
		} catch (ClassNotFoundException e) {
			System.err.println("Error clase JDBC");
		} catch (SQLException e) {
			System.err.println("Error SQL");
		}
	}
}
