package controlador;

import vista.VentanaBuscar;
import vista.VentanaCargar;
import vista.VentanaJuego;
import vista.VentanaPrincipal;

public class Principal {
	Coordinador miCoordinador;
	VentanaBuscar miVentanaBuscar;
	VentanaCargar miVentanaCargar;
	VentanaJuego miVentanaJuego;
	VentanaPrincipal miVentanaPrincipal;

	public static void main(String[] args) {
		
		Principal miPrincipal = new Principal();
		
		miPrincipal.iniciar();
		// TODO Auto-generated method stub

	}

	private void iniciar() {
		// TODO Auto-generated method stub
		miCoordinador = new Coordinador();
		miVentanaBuscar = new VentanaBuscar();
		miVentanaCargar = new VentanaCargar();
		miVentanaJuego = new VentanaJuego();
		miVentanaPrincipal = new VentanaPrincipal();
		
		miCoordinador.setMiVentanaBuscar(miVentanaBuscar);
		miCoordinador.setMiVentanaCargar(miVentanaCargar);
		miCoordinador.setMiVentanaJuego(miVentanaJuego);
		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
		
		miVentanaBuscar.setMiCoordinador(miCoordinador);
		miVentanaCargar.setMiCoordinador(miCoordinador);
		miVentanaJuego.setMiCoordinador(miCoordinador);
		miVentanaPrincipal.setMiCoordinador(miCoordinador); //Relacionamos los objetois con mi coordinador
		
		miVentanaPrincipal.setVisible(true);
	}
	

}
