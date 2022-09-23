package controlador;

import modelo.PreguntaDAO;
import modelo.PreguntaVo;
import vista.VentanaBuscar;
import vista.VentanaCargar;
import vista.VentanaJuego;
import vista.VentanaPrincipal;

public class Coordinador {
	
private VentanaPrincipal miVentanaPrincipal;
private VentanaCargar miVentanaCargar;
private VentanaJuego miVentanaJuego;
private VentanaBuscar miVentanaBuscar;


public VentanaPrincipal getMiVentanaPrincipal() {
	return miVentanaPrincipal;

}
public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
	this.miVentanaPrincipal = miVentanaPrincipal;
}
public VentanaCargar getMiVentanaCargar() {
	return miVentanaCargar;
}
public void setMiVentanaCargar(VentanaCargar miVentanaCargar) {
	this.miVentanaCargar = miVentanaCargar;
}
public VentanaJuego getMiVentanaJuego() {
	return miVentanaJuego;
}
public void setMiVentanaJuego(VentanaJuego miVentanaJuego) {
	this.miVentanaJuego = miVentanaJuego;
}
public VentanaBuscar getMiVentanaBuscar() {
	return miVentanaBuscar;
}
public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
	this.miVentanaBuscar = miVentanaBuscar;
}
public void mostrarVentanaPrincipal(){
	miVentanaPrincipal.setVisible(true);
	
}
public void mostrarVentanaCargar(){
	miVentanaCargar.setVisible(true);
	miVentanaCargar.limpiar();
}
public void mostratVentanaJuego(){
	
}
public void cargarPregunta(PreguntaVo miPreguntaVO) {//Creamos el  metodo, el objeto mipreguntadao y le pusimos al objeto el metodo cargar pregunta a los VO
	PreguntaDAO miPreguntaDAO = new PreguntaDAO();
	miPreguntaDAO.cargarPregunta(miPreguntaVO);
}
public void mostrarVentanaBuscar(int n, String nivel) {
	miVentanaBuscar.setVisible(true);
	miVentanaBuscar.setTitle("Nivel "+nivel);
	miVentanaBuscar.mostrarDatosConTableModel(n);
}
public void pasarDatos(PreguntaVo miPreguntaVO) {
	miVentanaCargar.mostrarPregunta(miPreguntaVO);
	
}
public void modificarPregunta(PreguntaVo miPreguntaVO) {
	PreguntaDAO miPreguntaDAO = new PreguntaDAO();
	miPreguntaDAO.modificarPregunta(miPreguntaVO);
}
public void eliminarPregunta(int ncai) {
	PreguntaDAO miPreguntaDAO = new PreguntaDAO();
	miPreguntaDAO.eliminarPregunta(ncai);
}
public void mostrarVentanaJuego() {
	miVentanaJuego.setVisible(true);
}


}
