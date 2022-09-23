package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.PreguntaDAO;
import modelo.PreguntaVo;

public class VentanaBuscar extends JFrame {

	private JPanel contentPane;
	Coordinador miCoordinador;
	private JTable tabla;
	JScrollPane scrollPane;

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
					VentanaBuscar frame = new VentanaBuscar();
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
	public VentanaBuscar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	public void mostrarDatosConTableModel(int n) {
		DefaultTableModel modelo = new DefaultTableModel();
		tabla = new JTable();
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				miCoordinador.pasarDatos(pasarDatosPregunta(e));
			}
		});
		tabla.setModel(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Pregunta");
		modelo.addColumn("Opción 1");
		modelo.addColumn("Opción 2");
		modelo.addColumn("Opción 3");
		modelo.addColumn("Opción 4");
		modelo.addColumn("Correcta");
		modelo.addColumn("Nivel");
		
		PreguntaDAO miPreguntaDAO = new PreguntaDAO();
		miPreguntaDAO.buscarPreguntas(modelo,n);
		
		scrollPane.setViewportView(tabla);
	}

	protected PreguntaVo pasarDatosPregunta(MouseEvent e) {
		PreguntaVo miPreguntaVO = new PreguntaVo();
		int row=tabla.rowAtPoint(e.getPoint());
	
		miPreguntaVO.setId(Integer.valueOf(tabla.getValueAt(row, 0).toString()));
		miPreguntaVO.setPregunta(tabla.getValueAt(row, 1).toString());
		miPreguntaVO.setOp1(tabla.getValueAt(row, 2).toString());
		miPreguntaVO.setOp2(tabla.getValueAt(row, 3).toString());
		miPreguntaVO.setOp3(tabla.getValueAt(row, 4).toString());
		miPreguntaVO.setOp4(tabla.getValueAt(row, 5).toString());
		miPreguntaVO.setrCorrecta(Integer.valueOf(tabla.getValueAt(row, 6).toString()));
		miPreguntaVO.setNivel(Integer.valueOf(tabla.getValueAt(row, 7).toString()));
		return miPreguntaVO;
	}
	

}
