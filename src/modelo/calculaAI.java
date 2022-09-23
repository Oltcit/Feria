package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class calculaAI {// clase auto incremental
	
	public int calculaID(){
		
		int id=1;
		
		Conexion con =new Conexion();
		ResultSet resId=null;
		
		try{
			String consulta="SELECT MAX(idpregunta) FROM pregunta";
			PreparedStatement estatuto = con.getConnection().prepareStatement(consulta);
			resId=estatuto.executeQuery();
			while (resId.next()){
				id=resId.getInt(1)+1;
			}
		
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Error no se conecto");
		}
		
		return id;
	}
	

}
