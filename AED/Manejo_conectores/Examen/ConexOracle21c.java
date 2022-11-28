package AED.Manejo_conectores.Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexOracle21c {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "1234");
            con.setAutoCommit(false);
            Statement sentence=con.createStatement();
            //Leo del fichero Inserciones.sql
            File file = new File("src\\AED\\Manejo_conectores\\Examen\\Inserciones.sql");
			if (!file.exists()) {
				System.out.println("No existe");
			} else {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String myquery = ""; 
				while ((myquery=br.readLine())!=null) {
					sentence.executeUpdate(myquery);
				}
                br.close();
                ResultSet result= sentence.executeQuery("Select * From Oficinas");
                while(result.next()){
                    System.out.println(result.getInt(1)+"-"+result.getString(2)+"-"+result.getString(3)+"-"+result.getString(4));
                }
                System.out.println("/----------------------------------------------------------------------------------------------------------------------------------------------------------------/");
                result= sentence.executeQuery("Select * From Empleados");
                while(result.next()){
                    System.out.println(result.getString(1)+"-"+result.getString(2)+"-"+result.getString(3)+"-"+result.getString(4)+"-"+result.getInt(5));
                }
                file = new File("src\\AED\\Manejo_conectores\\Examen\\Select.sql");
			    if (!file.exists()) {
				System.out.println("No existe");
			    } else {
				    br = new BufferedReader(new FileReader(file));
				    if((myquery=br.readLine())!=null) {
                        System.out.println("Obtener el nombre y direccion de los empleados que son vendores y trabajan en Telde");
					    result=sentence.executeQuery(myquery);
                        while (result.next()) {
                            System.out.println(result.getString(1)+"-"+result.getString(2));
                        }
				    }
                    if((myquery=br.readLine())!=null) {
                        System.out.println("Mostrar cuantos empleados trabajan en cada oficina");
                        //Porque si le pongo count(nombre_emp) no sirve y con nombre_emp si sirve
					    result=sentence.executeQuery(myquery);
                        while (result.next()) {
                            System.out.println(result.getString(1)+"-"+result.getString(2));
                        }
				    }
                    
                    if((myquery=br.readLine())!=null) {
                        System.out.println("Mostrar los cargos que ocupan el mayor numero de trabajadores y el menor");
					    result=sentence.executeQuery(myquery);
                        while (result.next()) {
                            System.out.println(result.getInt(1));
                        }
				    }
                    br.close();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
