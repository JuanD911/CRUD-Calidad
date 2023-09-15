package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Principal {

	public JFrame frmMonitor;
	private JButton btnMonitores;
	private JButton btnGrupos;
	private JButton btnInstructores;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonitor = new JFrame();
		frmMonitor.setTitle("Principal");
		frmMonitor.setBounds(100, 100, 644, 348);
		frmMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonitor.getContentPane().setLayout(null);
		
		btnMonitores = new JButton("Monitores");
		btnMonitores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMonitor.setVisible(false);
				monitorForm window = new monitorForm();
				window.frmMonitor.setVisible(true);
				Principal window2 = new Principal();
				window2.frmMonitor.setVisible(false);
			}
		});
		btnMonitores.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnMonitores.setBounds(216, 234, 196, 55);
		frmMonitor.getContentPane().add(btnMonitores);
		
		btnGrupos = new JButton("Grupos");
		btnGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMonitor.setVisible(false);
				grupoForm window = new grupoForm();
				window.frmMonitor.setVisible(true);
				Principal window2 = new Principal();
				window2.frmMonitor.setVisible(false);
			}
		});
		btnGrupos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGrupos.setBounds(10, 234, 196, 55);
		frmMonitor.getContentPane().add(btnGrupos);
		
		btnInstructores = new JButton("Instructores");
		btnInstructores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMonitor.setVisible(false);
				instructorForm window = new instructorForm();
				window.frmMonitor.setVisible(true);
				Principal window2 = new Principal();
				window2.frmMonitor.setVisible(false);
			}
		});
		btnInstructores.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnInstructores.setBounds(422, 234, 196, 55);
		frmMonitor.getContentPane().add(btnInstructores);
		
		lblNewLabel = new JLabel("Bienvenido\r\n\r\n a Atenea");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 27, 608, 145);
		frmMonitor.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Escoga una opción para continuar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 200, 608, 24);
		frmMonitor.getContentPane().add(lblNewLabel_1);
	}
}