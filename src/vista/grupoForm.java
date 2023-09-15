package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	List<Instructor> i = new ArrayList();
	List<Monitor> m = new ArrayList();
	private monitorDAO monitorDAO;
	private instructorDAO instructorDAO;
	private grupoDAO grupoDAO;

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
		btnEliminar.setBounds(310, 32, 196, 39);
		frmMonitor.getContentPane().add(btnEliminar);
		
		btnGuardar = new JButton("Guardar información de Grupo");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monitor m = (Monitor) comboBox_monitor.getSelectedItem();
				Instructor i = (Instructor) comboBox_instructor.getSelectedItem();
				grupoDAO.agregarGrupo(m.getId(), i.getId(), textField_nombre.getText());
			}
		});
		btnGuardar.setBounds(310, 93, 196, 39);
		frmMonitor.getContentPane().add(btnGuardar);
		
		btnActualizar = new JButton("Actualizar información del Grupo");
		btnActualizar.setBounds(310, 151, 196, 39);
		frmMonitor.getContentPane().add(btnActualizar);
	}
}
