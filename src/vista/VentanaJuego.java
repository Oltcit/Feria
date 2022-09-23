package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;

import javax.sound.midi.spi.MidiDeviceProvider;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.border.MatteBorder;

import controlador.Coordinador;
import modelo.PreguntaDAO;
import modelo.PreguntaVo;
import modelo.calculaAI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup bGroupNivel = new ButtonGroup();
	private final ButtonGroup bGroupOpcion = new ButtonGroup();
	
	Coordinador miCoordinador;
	private JRadioButton rbInicial;
	private JRadioButton rbPrimaria;
	private JRadioButton rbTerciario;
	private JRadioButton rbSecundaria;
	private JLabel lbl2;
	private JTextArea txtPregunta;
	private JLabel lbl1;
	private JLabel lbl3;
	private JLabel lbl4;
	private JRadioButton rb4;
	private JRadioButton rb1;
	private JRadioButton rb3;
	private JRadioButton rb2;
	private int correcta;
	private JButton btnPreguntar;
	private JButton btnComprobar;
	private JLabel lblNewLabel;
	private JLabel lblcorrectas;
	private int cantCorrectas=0,total=0;
	
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
					VentanaJuego frame = new VentanaJuego();
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
	public VentanaJuego() {
		setTitle("                 \u00A1\u00A1\u00A1Juguemos!!!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNivel = new JLabel("Seleccione Nivel");
		lblNivel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		
		rbInicial = new JRadioButton("Inicial");
		rbInicial.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		rbInicial.setSelected(true);
		bGroupNivel.add(rbInicial);
		
		rbPrimaria = new JRadioButton("Primaria");
		rbPrimaria.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		bGroupNivel.add(rbPrimaria);
		
		rbSecundaria = new JRadioButton("Secundaria");
		rbSecundaria.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		bGroupNivel.add(rbSecundaria);
		
		rbTerciario = new JRadioButton("Terciario");
		rbTerciario.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		bGroupNivel.add(rbTerciario);
		GroupLayout gl_panelNorte = new GroupLayout(panelNorte);
		gl_panelNorte.setHorizontalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addComponent(lblNivel)
					.addGap(47)
					.addComponent(rbInicial)
					.addGap(18)
					.addComponent(rbPrimaria)
					.addGap(18)
					.addComponent(rbSecundaria)
					.addGap(10)
					.addComponent(rbTerciario)
					.addGap(97))
		);
		gl_panelNorte.setVerticalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelNorte.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNivel)
						.addGroup(gl_panelNorte.createParallelGroup(Alignment.BASELINE)
							.addComponent(rbInicial)
							.addComponent(rbPrimaria)
							.addComponent(rbSecundaria)
							.addComponent(rbTerciario))))
		);
		panelNorte.setLayout(gl_panelNorte);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnPreguntar = new JButton("Preguntar");
		btnPreguntar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPregunta();
			}
		});
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.setEnabled(false);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnPreguntar);
		
		Component horizontalStrut = Box.createHorizontalStrut(150);
		panel.add(horizontalStrut);
		panel.add(btnComprobar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		txtPregunta = new JTextArea();
		txtPregunta.setBounds(10, 27, 691, 76);
		
		rb1 = new JRadioButton("Opci\u00F3n 1");
		rb1.setBounds(87, 130, 109, 23);
		bGroupOpcion.add(rb1);
		
		rb2 = new JRadioButton("Opci\u00F3n 2");
		rb2.setBounds(87, 171, 109, 23);
		bGroupOpcion.add(rb2);
		
		rb3 = new JRadioButton("Opci\u00F3n 3");
		rb3.setBounds(429, 130, 109, 23);
		bGroupOpcion.add(rb3);
		
		rb4 = new JRadioButton("Opci\u00F3n 4");
		rb4.setBounds(429, 171, 109, 23);
		bGroupOpcion.add(rb4);
		panel_1.setLayout(null);
		panel_1.add(txtPregunta);
		panel_1.add(rb1);
		panel_1.add(rb2);
		panel_1.add(rb3);
		panel_1.add(rb4);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(45, 114, 35, 39);
		panel_1.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setBounds(45, 155, 35, 39);
		panel_1.add(lbl2);
		
		lbl4 = new JLabel("");
		lbl4.setBounds(388, 155, 35, 39);
		panel_1.add(lbl4);
		
		lbl3 = new JLabel("");
		lbl3.setBounds(388, 114, 35, 39);
		panel_1.add(lbl3);
		
		lblNewLabel = new JLabel("Correctas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(456, 228, 119, 46);
		panel_1.add(lblNewLabel);
		
		lblcorrectas = new JLabel("");
		lblcorrectas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblcorrectas.setBounds(585, 228, 89, 43);
		panel_1.add(lblcorrectas);
	}

	protected void comprobar() {
		total++;
		if (!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected() && !rb4.isSelected()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una opción");
			total--;
		}	
		else {
			btnComprobar.setEnabled(false);
			btnPreguntar.setEnabled(true);
		}
		
		if (rb1.isSelected()) {
			if (correcta==1) {
				lbl1.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/tilde.png")));
				cantCorrectas++;
			}
			else
				lbl1.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/cruz.png")));
		}
		if (rb2.isSelected()) {
			if (correcta==2) {
				lbl2.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/tilde.png")));
				cantCorrectas++;
			}
			else
				lbl2.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/cruz.png")));
		}
		if (rb3.isSelected()) {
			if (correcta==3) {
				lbl3.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/tilde.png")));
				cantCorrectas++;
			}
			else
				lbl3.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/cruz.png")));
		}
		if (rb4.isSelected()) {
			if (correcta==4) {
				lbl4.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/tilde.png")));
				cantCorrectas++;
			}
			else
				lbl4.setIcon(new ImageIcon(VentanaJuego.class.getResource
						("/imagenes/cruz.png")));
		}
		
		lblcorrectas.setText(String.valueOf(cantCorrectas+" de "+total));
		
	}

	protected void mostrarPregunta() {
		limpiar();
		btnPreguntar.setEnabled(false);
		btnComprobar.setEnabled(true);
		int nivel=0;
		if (rbInicial.isSelected())
			nivel=1;
		if (rbPrimaria.isSelected())
			nivel=2;
		if (rbSecundaria.isSelected())
			nivel=3;
		if (rbTerciario.isSelected())
			nivel=4;
		
		
		PreguntaDAO miPreguntaDAO = new PreguntaDAO();
		mostrarPregunta(miPreguntaDAO.cargarPreguntasPorNivel(nivel));
		
	}
	
	private void mostrarPregunta(PreguntaVo miP) {
			
			txtPregunta.setText(miP.getPregunta());
			rb1.setText(miP.getOp1());
			rb2.setText(miP.getOp2());
			rb3.setText(miP.getOp3());
			rb4.setText(miP.getOp4());
			correcta=miP.getrCorrecta();
	}
	
	private void limpiar() {
		bGroupOpcion.clearSelection();
		lbl1.setIcon(null);
		lbl2.setIcon(null);
		lbl3.setIcon(null);
		lbl4.setIcon(null);
	}
	
}
