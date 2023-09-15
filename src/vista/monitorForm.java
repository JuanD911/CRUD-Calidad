	package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DAO.*;
import modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class monitorForm {

	public JFrame frmMonitor;
	private JTextField textField_nombre;
	private JTextField textField_telefono;
	private JTextField textField_fecha;
	private JTextField textField_direccion;
	private JTextField textField_correo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JTable table;
	private monitorDAO monitorDAO;
	List<Monitor> m = new ArrayList();
	private JButton btnActualizar_deverdad;
	String id_a;

	/**
	 * Create the application.
	 */
	public monitorForm() {
		initialize();
		monitorDAO = new monitorDAO();
		cargarDatos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void cargarDatos() {
		m.clear();
		m = monitorDAO.consultarMonitores();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for(Monitor user:m) {
			int id = user.getId();
			String nombre = user.getNombre();
			String telefono = user.getTelefono();
			String direccion = user.getDireccion();
			String correo = user.getC_electronico();
			String fecha = user.getF_nacimiento();
			
			Vector fila = new Vector();
			fila.add(id);
			fila.add(nombre);
			fila.add(telefono);
			fila.add(direccion);
			fila.add(correo);
			fila.add(fecha);
			
			System.out.println(user.getNombre());
			model.addRow(fila);
		}
		
	}
	
	private void initialize() {
		frmMonitor = new JFrame();
		frmMonitor.setTitle("Monitor");
		frmMonitor.setBounds(100, 100, 1080, 348);
		frmMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonitor.getContentPane().setLayout(null);
		
		JLabel lblnombre = new JLabel("Ingrese el nombre del monitor");
		lblnombre.setBounds(24, 29, 181, 13);
		frmMonitor.getContentPane().add(lblnombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(24, 52, 214, 19);
		textField_nombre.setText("");
		frmMonitor.getContentPane().add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lbltelefono = new JLabel("Ingrese el telefono del monitor");
		lbltelefono.setBounds(24, 81, 214, 13);
		frmMonitor.getContentPane().add(lbltelefono);
		
		textField_telefono = new JTextField();
		textField_telefono.setBounds(24, 104, 214, 19);
		frmMonitor.getContentPane().add(textField_telefono);
		textField_telefono.setColumns(10);
		
		JLabel lblfecha = new JLabel("Ingrese la fecha de nacimiento (dd/mm/aa)");
		lblfecha.setBounds(24, 133, 250, 13);
		frmMonitor.getContentPane().add(lblfecha);
		
		textField_fecha = new JTextField();
		textField_fecha.setBounds(24, 156, 214, 19);
		frmMonitor.getContentPane().add(textField_fecha);
		textField_fecha.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Ingrese la direccion del monitor");
		lblDireccion.setBounds(24, 185, 250, 13);
		frmMonitor.getContentPane().add(lblDireccion);
		
		textField_direccion = new JTextField();
		textField_direccion.setBounds(24, 208, 214, 19);
		textField_direccion.setText("");
		textField_direccion.setColumns(10);
		frmMonitor.getContentPane().add(textField_direccion);
		
		JLabel lblcorreo = new JLabel("Ingrese el correo electronico del monitor");
		lblcorreo.setBounds(24, 238, 269, 13);
		frmMonitor.getContentPane().add(lblcorreo);
		
		textField_correo = new JTextField();
		textField_correo.setBounds(24, 261, 214, 19);
		textField_correo.setColumns(10);
		frmMonitor.getContentPane().add(textField_correo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(302, 251, 196, 39);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal window = new Principal();
				window.frmMonitor.setVisible(true);
				frmMonitor.setVisible(false);
			}
		});
		frmMonitor.getContentPane().add(btnVolver);
		
		btnGuardar = new JButton("Guardar información de Monitor");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monitorDAO.agregarMonitor(textField_nombre.getText(), textField_telefono.getText(), textField_direccion.getText(), textField_correo.getText(), textField_fecha.getText());
				cargarDatos();
			}
		});
		btnGuardar.setBounds(302, 146, 196, 39);
		frmMonitor.getContentPane().add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar Monitor");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_e = JOptionPane.showInputDialog(null, "Escriba el ID del monitor que desea eliminar");
				monitorDAO.eliminarMonitor(Integer.parseInt(id_e));
				cargarDatos();
			}
		});
		btnEliminar.setBounds(302, 42, 196, 39);
		frmMonitor.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar información del Monitor");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_a = JOptionPane.showInputDialog(null, "Escriba el ID del monitor que desea actualizar");
				Monitor m = monitorDAO.ponerMonitorEnTextFields(Integer.parseInt(id_a));
				
				textField_nombre.setText(m.getNombre());
				textField_telefono.setText(m.getTelefono());
				textField_direccion.setText(m.getDireccion());
				textField_correo.setText(m.getC_electronico());
				textField_fecha.setText(m.getF_nacimiento());
				
				btnActualizar_deverdad.setVisible(true);
				
			}
		});
		btnActualizar.setBounds(302, 94, 196, 39);
		frmMonitor.getContentPane().add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(532, 33, 510, 257);
		frmMonitor.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOMBRE", "TELEFONO", "CORREO", "FECHA NACIMIENTO", "DIRECCION"
			}
		));
		scrollPane.setViewportView(table);
		
		btnActualizar_deverdad = new JButton("Confirmar actualización");
		btnActualizar_deverdad.setEnabled(true);
		btnActualizar_deverdad.setVisible(false);
		btnActualizar_deverdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monitorDAO.actualizarMonitor(Integer.parseInt(id_a), textField_nombre.getText(), textField_telefono.getText(), textField_direccion.getText(), textField_correo.getText(), textField_fecha.getText());
				cargarDatos();
			}
		});
		btnActualizar_deverdad.setBounds(302, 195, 196, 39);
		frmMonitor.getContentPane().add(btnActualizar_deverdad);
	}
}