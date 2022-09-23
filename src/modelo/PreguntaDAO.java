package modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PreguntaDAO {
	public void cargarPregunta(PreguntaVo miPreguntaVO){
		
		try{
			Conexion conex =new Conexion();
			Statement estatuto=conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO pregunta VALUES ('"+0+"','"+miPreguntaVO.getPregunta()+"','"+miPreguntaVO.getOp1()+"','"+
					miPreguntaVO.getOp2()+"','"+miPreguntaVO.getOp3()+"','"+miPreguntaVO.getOp4()+"','"+
					+miPreguntaVO.getrCorrecta()+"','"+miPreguntaVO.getNivel()+"')");
			
			JOptionPane.showMessageDialog(null, "Su Pregunta se ha registrado exitosamente","Informacion",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, "No se registró la pregunta", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
			
		}
		
		
	}

	public void buscarPreguntas(DefaultTableModel modelo, int n) {
		
		try {
			Conexion conex =new Conexion();
			String consulta = "SELECT * FROM pregunta where nivel=?";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			estatuto.setInt(1, n);
			ResultSet res = estatuto.executeQuery();
			
			while (res.next()) {
				Object fila[]=new Object[8];
				for (int i=0;i<8;i++) {
					fila[i]=res.getObject(i+1);
				}
				
				modelo.addRow(fila);
			}
			res.close();
			estatuto.close();
			conex.desconectar();
			
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Error al consultar", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
			
		}
	}

	

	public void modificarPregunta(PreguntaVo miPreguntaVO) {
		
		try{
			Conexion conex= new Conexion();
			
			String consulta="UPDATE pregunta SET idpregunta= ? ,pregunta = ? , op1=? , op2=? , op3= ?, op4=? , opcorr= ?"
					+ ",nivel= ? WHERE idpregunta= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miPreguntaVO.getId());
            estatuto.setString(2, miPreguntaVO.getPregunta());
            estatuto.setString(3, miPreguntaVO.getOp1());
            estatuto.setString(4, miPreguntaVO.getOp2());
            estatuto.setString(5, miPreguntaVO.getOp3());
            estatuto.setString(6, miPreguntaVO.getOp4());
            estatuto.setInt(7, miPreguntaVO.getrCorrecta());
            estatuto.setInt(8, miPreguntaVO.getNivel());
            estatuto.setInt(9, miPreguntaVO.getId());
            estatuto.executeUpdate();
		
            System.out.println("Correcta: "+miPreguntaVO.getrCorrecta()+"consulta "+consulta);
            System.out.println("Id pregunta "+miPreguntaVO.getId());
            
            JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
         
			estatuto.close();
			conex.desconectar();
        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
		
	}

	public void eliminarPregunta(int ncai) {
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM pregunta WHERE idpregunta='"+ncai+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}		
	}

	private int contarRegistros(int n) {
		int cant=0;
		try {
			Conexion conex =new Conexion();
			String consulta = "SELECT * FROM pregunta where nivel=?";
			PreparedStatement estatuto1 = conex.getConnection().prepareStatement(consulta);
			estatuto1.setInt(1, n);
			ResultSet res1 = estatuto1.executeQuery();
			
			
			while (res1.next()) {
				cant++;
				}
			
			res1.close();
			estatuto1.close();
			conex.desconectar();
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Error al contar", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
			
		}
		System.out.println(cant);
		return cant;
		
	}
	
	public PreguntaVo cargarPreguntasPorNivel(int n) {
		PreguntaVo miPreguntaVo = new PreguntaVo();
		try {
			Conexion conex =new Conexion();
			String consulta = "SELECT * FROM pregunta where nivel=?";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			estatuto.setInt(1, n);
			ResultSet res = estatuto.executeQuery();
			
			int cant=contarRegistros(n);
			int ale=aleatorio(cant);
			System.out.println("aleatorio: "+ale);
			int ciclo=0;
			
			
			
			while (ciclo != ale && res.next()) {
				
				miPreguntaVo.setId(Integer.valueOf(res.getObject(1).toString()));
				miPreguntaVo.setPregunta(res.getObject(2).toString());
				miPreguntaVo.setOp1(res.getObject(3).toString());
				miPreguntaVo.setOp2(res.getObject(4).toString());
				miPreguntaVo.setOp3(res.getObject(5).toString());
				miPreguntaVo.setOp4(res.getObject(6).toString());
				miPreguntaVo.setrCorrecta(Integer.valueOf(res.getObject(7).toString()));
				miPreguntaVo.setNivel(Integer.valueOf(res.getObject(8).toString()));
				//res.next();
				ciclo++;
				
			}
			res.close();
			estatuto.close();
			conex.desconectar();
			
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Error al consultar 1", "ERROR", 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}
		return miPreguntaVo;
		
	}
	private int aleatorio(int max) {
		
		//int max=cai.calculaID()-1;
		Random r = new Random();	
		//nextDouble genera un número aleatorio Double entre 0.0 y 1.0 pero nunca mayor a 1.
		int	n = r.nextInt(max-1+1)+1;
		return n;	
	}
}
