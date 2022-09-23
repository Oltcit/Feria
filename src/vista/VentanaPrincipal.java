package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	Coordinador miCoordinador;

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("   Preguntados del 44");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargarPreguntas = new JButton("Cargar preguntas");
		btnCargarPreguntas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar();
			}
		});
		btnCargarPreguntas.setBounds(233, 52, 150, 23);
		contentPane.add(btnCargarPreguntas);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugar();
			}
		});
		btnJugar.setBounds(233, 145, 150, 23);
		contentPane.add(btnJugar);
	}

	protected void jugar() {
		miCoordinador.mostrarVentanaJuego();
	}

	protected void cargar() {
		//VentanaCargar mive=new VentanaCargar();
		//mive.setVisible(true);
		//this.dispose();
		miCoordinador.mostrarVentanaCargar();
		
	}
}
