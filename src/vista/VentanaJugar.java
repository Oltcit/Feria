package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaJugar extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbUno;
	private JRadioButton rbTres;
	private JRadioButton rbCuatro;
	private JRadioButton rbDos;
	private JTextArea txtPregunta;
	private JLabel lbl4;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJugar frame = new VentanaJugar();
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
	public VentanaJugar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 603, 117);
		contentPane.add(scrollPane);
		
		txtPregunta = new JTextArea();
		txtPregunta.setWrapStyleWord(true);
		txtPregunta.setLineWrap(true);
		scrollPane.setViewportView(txtPregunta);
		
		rbUno = new JRadioButton("");
		buttonGroup.add(rbUno);
		rbUno.setBounds(10, 228, 554, 23);
		contentPane.add(rbUno);
		
		rbDos = new JRadioButton("");
		buttonGroup.add(rbDos);
		rbDos.setBounds(10, 265, 554, 23);
		contentPane.add(rbDos);
		
		rbTres = new JRadioButton("");
		buttonGroup.add(rbTres);
		rbTres.setBounds(10, 303, 554, 23);
		contentPane.add(rbTres);
		
		rbCuatro = new JRadioButton("");
		buttonGroup.add(rbCuatro);
		rbCuatro.setBounds(10, 344, 554, 23);
		contentPane.add(rbCuatro);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Inicial", "Primaria", "Secundaria", "Terciario"}));
		comboBox.setBounds(83, 11, 141, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Nivel:");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.setBounds(157, 397, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.setBounds(372, 397, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(575, 228, 38, 23);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setBounds(575, 265, 38, 23);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setBounds(575, 303, 38, 23);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setBounds(575, 344, 38, 23);
		contentPane.add(lbl4);
	}
	public JLabel getLbl4() {
		return lbl4;
	}
	public JLabel getLbl1() {
		return lbl1;
	}
	public JLabel getLbl2() {
		return lbl2;
	}
	public JLabel getLbl3() {
		return lbl3;
	}
}
