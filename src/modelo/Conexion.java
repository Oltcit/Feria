package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	static String bd = "Preguntas";
	static String login ="root";
	static String password="Admin";
	
	//String url= "jdbc:mysql://localhost:3306/mesaexamen?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	   String url= "jdbc:mysql://localhost:3306/"+bd+"?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Argentina/Buenos_Aires";
	   Connection conn = null;

	   /** Constructor de DbConnection */
	   public Conexion() {
	      try{
	         //obtenemos el driver de para mysql
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         //obtenemos la conexi�n
	         conn = DriverManager.getConnection(url,login,password);

	         if (conn!=null){
	            System.out.println("Conecci�n a base de datos "+bd+" OK");
	         }
	      }
	      catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	    	  e.printStackTrace();
	         System.out.println(e);
	      }
	   }
	   /**
	    * Permite retornar la conexión
	    * */
	   public Connection getConnection(){
	      return conn;
	   }
	   /**
	    * Finaliza la conexión con la Base de Datos
	    */
	   public void desconectar(){
	      conn = null;
	   }



}
