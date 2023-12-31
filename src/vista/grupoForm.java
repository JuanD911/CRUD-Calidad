package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Grupo;
import modelo.Instructor;
import modelo.Monitor;
import modelo.DAO.*;

import javax.swing.JComboBox;

public class grupoForm {

	public JFrame frmMonitor;
	private JTable table;
	private JTextField textField_nombre;
	private JLabel lblNewLabel;
	private JButton btnVolver;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox_instructor;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox_monitor;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnConfirmarInformacion;
	List<Instructor> i = new ArrayList();
	List<Monitor> m = new ArrayList();
	List<Grupo> g = new ArrayList();
	private monitorDAO monitorDAO;
	private instructorDAO instructorDAO;
	private grupoDAO grupoDAO;
	private String id_a;

	/**
	 * Create the application.
	 */
	public grupoForm() {
		initialize();
		instructorDAO = new instructorDAO();
		monitorDAO = new monitorDAO();
		grupoDAO = new grupoDAO();
		cargarDatos();
	}

	public void cargarDatos() {
		i.clear();
		i = instructorDAO.consultarInstructores();

		for(Instructor user:i) {
			int id = user.getId();
			String nombre = user.getNombre();
			String telefono = user.getTelefono();
			String direccion = user.getDireccion();
			String correo = user.getC_electronico();
			String fecha = user.getF_nacimiento();
			
			Instructor in = new Instructor(id, nombre, telefono, direccion, correo, fecha);
			
			comboBox_instructor.addItem(in);
			
			System.out.println(user.getNombre());

		
		}
		m.clear();
		m = monitorDAO.consultarMonitores();

		for(Monitor user:m) {
			
			int id = user.getId();
			String nombre = user.getNombre();
			String telefono = user.getTelefono();
			String direccion = user.getDireccion();
			String correo = user.getC_electronico();
			String fecha = user.getF_nacimiento();
			
			Monitor mo = new Monitor(id, nombre, telefono, direccion, correo, fecha);
			
			comboBox_monitor.addItem(mo);
			
			System.out.println(user.getNombre());

		}
		
		g.clear();
		g = grupoDAO.consultarGrupos();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(Grupo user:g) {
			int id = user.getId();
			int monitor = user.getMonitor();
			int instructor = user.getInstructor();
			String nombre = user.getNombre();
			
			Vector fila = new Vector();
			fila.add(id);
			
			for(Monitor user_m:m) {
				if(user_m.getId() == monitor) {
					fila.add(user_m.getNombre());
				}
			}
			
			for(Instructor user_i:i) {
				if(user_i.getId() == instructor) {
					fila.add(user_i.getNombre());
				}
			}
			
			
			fila.add(nombre);
			
			model.addRow(fila);
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonitor = new JFrame();
		frmMonitor.setTitle("Grupo");
		frmMonitor.setBounds(100, 100, 1080, 348);
		frmMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonitor.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(546, 10, 510, 291);
		frmMonitor.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Instructor", "Monitor"
			}
		));
		scrollPane.setViewportView(table);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(10, 52, 244, 19);
		frmMonitor.getContentPane().add(textField_nombre);
		textField_nombre.setColumns(10);
		
		lblNewLabel = new JLabel("Ingrese el nombre del grupo");
		lblNewLabel.setBounds(10, 29, 244, 13);
		frmMonitor.getContentPane().add(lblNewLabel);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal window = new Principal();
				window.frmMonitor.setVisible(true);
				frmMonitor.setVisible(false);
			}
		});
		btnVolver.setBounds(310, 262, 196, 39);
		frmMonitor.getContentPane().add(btnVolver);
		
		lblNewLabel_1 = new JLabel("Seleccione instructor");
		lblNewLabel_1.setBounds(10, 90, 244, 13);
		frmMonitor.getContentPane().add(lblNewLabel_1);
		
		comboBox_instructor = new JComboBox();
		comboBox_instructor.setBounds(10, 113, 244, 19);
		frmMonitor.getContentPane().add(comboBox_instructor);
		
		lblNewLabel_2 = new JLabel("Seleccione monitor");
		lblNewLabel_2.setBounds(10, 142, 244, 13);
		frmMonitor.getContentPane().add(lblNewLabel_2);
		
		comboBox_monitor = new JComboBox();
		comboBox_monitor.setBounds(10, 161, 244, 19);
		frmMonitor.getContentPane().add(comboBox_monitor);
		
		btnEliminar = new JButton("Eliminar Grupo");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_e = JOptionPane.showInputDialog(null, "Escriba el ID del grupo que desea eliminar");
				grupoDAO.eliminarGrupo(Integer.parseInt(id_e));
				cargarDatos();
			}
		});
		btnEliminar.setBounds(310, 32, 196, 39);
		frmMonitor.getContentPane().add(btnEliminar);
		
		btnGuardar = new JButton("Guardar información de Grupo");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monitor m = (Monitor) comboBox_monitor.getSelectedItem();
				Instructor i = (Instructor) comboBox_instructor.getSelectedItem();
				grupoDAO.agregarGrupo(m.getId(), i.getId(), textField_nombre.getText());
				cargarDatos();
			}
		});
		btnGuardar.setBounds(310, 93, 196, 39);
		frmMonitor.getContentPane().add(btnGuardar);
		
		btnActualizar = new JButton("Actualizar información del Grupo");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_a = JOptionPane.showInputDialog(null, "Escriba el ID del grupo que desea actualizar");
				Grupo g = grupoDAO.ponerGrupoEnTextFields(Integer.parseInt(id_a));
				
				textField_nombre.setText(g.getNombre());
				btnConfirmarInformacion.setVisible(true);
				
			}
		});
		btnActualizar.setBounds(310, 151, 196, 39);
		frmMonitor.getContentPane().add(btnActualizar);
		
		btnConfirmarInformacion = new JButton("Confirmar información");
		btnConfirmarInformacion.setVisible(false);
		btnConfirmarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monitor m = (Monitor) comboBox_monitor.getSelectedItem();
				Instructor i = (Instructor) comboBox_instructor.getSelectedItem();
				grupoDAO.actualizarGrupo(Integer.parseInt(id_a), m.getId(), i.getId(), textField_nombre.getText());
				cargarDatos();
			}
		});
		btnConfirmarInformacion.setBounds(310, 213, 196, 39);
		frmMonitor.getContentPane().add(btnConfirmarInformacion);
	}
}
