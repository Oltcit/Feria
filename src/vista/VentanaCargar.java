package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.PreguntaDAO;
import modelo.PreguntaVo;
import modelo.calculaAI;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaCargar extends JFrame {

	private JPanel contentPane;
	private JTextField txtPregunta;
	private JTextField txtOp1;
	private JTextField txtOp2;
	private JTextField txtOp3;
	private JTextField txtOp4;
	private JComboBox cbNivel;
	private JComboBox cbResp;
	private Coordinador miCoordinador;
	private int accion;
	private int ncai;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	
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
					VentanaCargar frame = new VentanaCargar();
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
	public VentanaCargar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSur = new JPanel();
		panelSur.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarPregunta();
			}

			
		});
		panelSur.add(btnGuardar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPregunta();
			}
		});
		panelSur.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPregunta();
			}
		});
		panelSur.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPregunta();
			}
		});
		panelSur.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		panelSur.add(btnBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		panelSur.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(10, 22, 59, 14);
		panel_1.add(lblNivel);
		
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(new String[] {"Inicial", "Primaria", "Secundaria", "Terciario"}));
		cbNivel.setBounds(99, 19, 186, 20);
		panel_1.add(cbNivel);
		
		JLabel lblIngreseLaPregunta = new JLabel("Pregunta:");
		lblIngreseLaPregunta.setBounds(10, 58, 59, 14);
		panel_1.add(lblIngreseLaPregunta);
		
		txtPregunta = new JTextField();
		txtPregunta.setBounds(99, 54, 535, 20);
		panel_1.add(txtPregunta);
		txtPregunta.setColumns(10);
		
		JLabel lblOp1 = new JLabel("Opci\u00F3n 1:");
		lblOp1.setBounds(10, 94, 59, 14);
		panel_1.add(lblOp1);
		
		txtOp1 = new JTextField();
		txtOp1.setBounds(100, 91, 185, 20);
		panel_1.add(txtOp1);
		txtOp1.setColumns(10);
		
		txtOp2 = new JTextField();
		txtOp2.setColumns(10);
		txtOp2.setBounds(100, 127, 185, 20);
		panel_1.add(txtOp2);
		
		JLabel lblOp2 = new JLabel("Opci\u00F3n 2:");
		lblOp2.setBounds(10, 130, 59, 14);
		panel_1.add(lblOp2);
		
		txtOp3 = new JTextField();
		txtOp3.setColumns(10);
		txtOp3.setBounds(100, 163, 185, 20);
		panel_1.add(txtOp3);
		
		JLabel lblOp3 = new JLabel("Opci\u00F3n 3:");
		lblOp3.setBounds(10, 166, 59, 14);
		panel_1.add(lblOp3);
		
		txtOp4 = new JTextField();
		txtOp4.setColumns(10);
		txtOp4.setBounds(100, 199, 185, 20);
		panel_1.add(txtOp4);
		
		JLabel lblOp4 = new JLabel("Opci\u00F3n 4:");
		lblOp4.setBounds(10, 202, 59, 14);
		panel_1.add(lblOp4);
		
		JLabel lblOpcionCorrecta = new JLabel("Respuesta correcta:");
		lblOpcionCorrecta.setBounds(331, 94, 98, 14);
		panel_1.add(lblOpcionCorrecta);
		
		cbResp = new JComboBox();
		cbResp.setModel(new DefaultComboBoxModel(new String[] {"Opci\u00F3n 1", "Opci\u00F3n 2", "Opci\u00F3n 3", "Opci\u00F3n 4"}));
		cbResp.setBounds(441, 91, 98, 20);
		panel_1.add(cbResp);
		
		limpiar();
	}
	protected void eliminarPregunta() {
		int respuesta=JOptionPane.showConfirmDialog(null, "Está seguro de eliminar esa pregunta?", "Confirmación", JOptionPane.YES_NO_OPTION);
					
			
			if (respuesta == JOptionPane.YES_NO_OPTION)
			{
				miCoordinador.eliminarPregunta(ncai);
				limpiar();
			}
		
		
	}

	protected void buscar() {
		int n=cbNivel.getSelectedIndex()+1;
		String nivel=cbNivel.getSelectedItem().toString();
		miCoordinador.mostrarVentanaBuscar(n, nivel);
	}

	protected void modificarPregunta() {
		accion =2;
		habilita(true, true, true, true, true, true, true, true, false, false, false, true, true);
		
	}

	protected void guardarPregunta() {
			
			try{
			PreguntaVo miPreguntaVO = new PreguntaVo();
			miPreguntaVO.setId(ncai);
			miPreguntaVO.setPregunta(txtPregunta.getText());
			miPreguntaVO.setOp1(txtOp1.getText());
			miPreguntaVO.setOp2(txtOp2.getText());
			miPreguntaVO.setOp3(txtOp3.getText());
			miPreguntaVO.setOp4(txtOp4.getText());
			miPreguntaVO.setrCorrecta(cbResp.getSelectedIndex()+1);
			miPreguntaVO.setNivel(cbNivel.getSelectedIndex()+1);
			
			if (accion ==1){
				miCoordinador.cargarPregunta(miPreguntaVO);
				limpiar();
			}else { 
				miCoordinador.modificarPregunta (miPreguntaVO);
				limpiar();
			}				
			}catch (Exception e){
				JOptionPane.showMessageDialog(null, "Error en el ingreso de la pregunta", "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				limpiar();
				
			}
	}

	protected void agregarPregunta() {
		// TODO Auto-generated method stub
		accion = 1;//Vas a crear un registro nuevo
		calculaAI cai= new calculaAI();
		ncai = cai.calculaID();
		habilita(true, true, true, true, true, true, true, true, false, false, false, false, true);
	}

	public void limpiar (){
		cbNivel.setSelectedIndex(0);
		txtPregunta.setText("");
		txtOp1.setText("");
		txtOp2.setText("");
		txtOp3.setText("");
		txtOp4.setText("");
		cbResp.setSelectedIndex(0);
		

		habilita(true, false, false, false, false, false, false, false, true, false, false, true, true);
		}
	private void habilita(boolean cbNiv, boolean txtPreg, boolean txtop1,
			boolean txtop2, boolean txtop3, boolean txtop4, boolean cbres,
			boolean btnGuarda, boolean btnAgrega, boolean btnMod, 
			boolean btnElimina, boolean btnBusca, boolean btnCancela ) {
		
		cbNivel.setEnabled(cbNiv);
		txtPregunta.setEditable(txtPreg);
		txtOp1.setEditable(txtop1);
		txtOp2.setEditable(txtop2);
		txtOp3.setEditable(txtop3);
		txtOp4.setEditable(txtop4);
		cbResp.setEnabled(cbres);
		btnGuardar.setVisible(btnGuarda);
		btnAgregar.setVisible(btnAgrega);
		btnModificar.setVisible(btnMod);
		btnEliminar.setVisible(btnElimina);
		btnBuscar.setVisible(btnBusca);
		btnCancelar.setVisible(btnCancela);
		
	}

	public void mostrarPregunta(PreguntaVo miPreguntaVO) {
		ncai=miPreguntaVO.getId();
		cbNivel.setSelectedIndex(miPreguntaVO.getNivel()-1);
		txtPregunta.setText(miPreguntaVO.getPregunta());
		txtOp1.setText(miPreguntaVO.getOp1());
		txtOp2.setText(miPreguntaVO.getOp2());
		txtOp3.setText(miPreguntaVO.getOp3());
		txtOp4.setText(miPreguntaVO.getOp4());
		cbResp.setSelectedIndex(miPreguntaVO.getrCorrecta()-1);
		
		habilita(true, false, false, false, false, false, false, false, false, true, true, true, true);
	}
	
}
